package ecommerce.controller;

import ecommerce.entity.Product;
import ecommerce.entity.ProductDetail;
import ecommerce.entity.Req.ProductDetailReq;
import ecommerce.service.IProductDetailService;
import ecommerce.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;
    private final IProductDetailService productDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductDetail(@PathVariable Long id, @RequestParam Integer colorId, @RequestParam Integer sizeId) {
        if (sizeId == 0) sizeId = null;
        if (colorId == 0) colorId = null;
        return ResponseEntity.ok(productDetailService.findByProductIdAndColorProductIdAndSizeProductId(id, colorId, sizeId));
    }

    @GetMapping("/by-owner/{accountId}")
    public ResponseEntity<Page<Product>> findByAccountIdAndNameContaining(@PathVariable Long accountId,
                                                                          @RequestParam String nameSearch,
                                                                          @RequestParam(value = "page", defaultValue = "0") int page,
                                                                          @RequestParam(value = "size", defaultValue = "33") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productService.findByAccountIdAndNameContaining(accountId, nameSearch, pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/by-product/{id}")
    public ResponseEntity<List<ProductDetail>> findByProductId(@PathVariable Long id) {
        List<ProductDetail> productDetails = productDetailService.findByProductId(id);
        return ResponseEntity.ok(productDetails);
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<ProductDetailReq> findByProductId(@PathVariable Long id, @RequestBody ProductDetailReq productDetailReq) {
        productDetailService.save(id, productDetailReq);
        return ResponseEntity.ok(productDetailReq);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        productDetailService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search-all")
    public ResponseEntity<Page<Product>> findByAll(
            @RequestParam(value = "nameSearch", required = false) String nameSearch,
            @RequestParam(value = "minPrice", defaultValue = "0") double minPrice,
            @RequestParam(value = "maxPrice", defaultValue = "0") double maxPrice,
            @RequestParam(value = "colorId", defaultValue = "0") Integer colorId,
            @RequestParam(value = "sizeId", defaultValue = "0") Integer sizeId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "30") int size,
            @RequestParam(value = "sort", defaultValue = "") String sort,
            @RequestParam(value = "direction", defaultValue = "asc") String direction
    ) {
        Page<Product> products = productService.findDistinctByFilters(nameSearch, minPrice, maxPrice, colorId, sizeId, sort, direction, page, size);
        return ResponseEntity.ok(products);
    }
}
