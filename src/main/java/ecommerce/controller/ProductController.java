package ecommerce.controller;

import ecommerce.entity.Product;
import ecommerce.entity.ProductDetail;
import ecommerce.service.IProductDetailService;
import ecommerce.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
@RequiredArgsConstructor

public class ProductController {
    private final IProductService productService;
    private final IProductDetailService productDetailService;


    @GetMapping
    public Page<ProductDetail> getAllProducts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "100") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.getAllProductDetail(pageable);
    }

    @GetMapping("/category/{id}")
    public Page<ProductDetail> getAllProductsByCategory(@PathVariable Long id,
                                                        @RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "24") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productDetailService.getAllProductDetail(id, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/by-owner/{id}")
    public ResponseEntity<?> getProductByUser(@PathVariable Long id, Pageable pageable) {
        Page<Product> products = productService.findByUserId(id,pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByName(@RequestParam("nameSearch") String name,
                                          @RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "24") int size) {
        Pageable pageable = PageRequest.of(page, size);
//        Page<Product> products = productService.findByNameContaining(name, pageable);
        return ResponseEntity.ok("products");
    }


    @GetMapping("/search-all")
    public ResponseEntity<?> findByAll(
            @RequestParam("nameSearch") String nameSearch,
            @RequestParam("minPrice") Double minPrice,
            @RequestParam("maxPrice") Double maxPrice,
            @RequestParam("colorName") String colorName,
            @RequestParam("sizeName") String sizeName,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "24") int size,
            @RequestParam(value = "sort", defaultValue = "") String sort,
            @RequestParam(value = "direction", defaultValue = "asc") String direction
    ) {
        double maxPriceCover = (maxPrice != 0) ? maxPrice : Double.MAX_VALUE;
        String name = (nameSearch.trim().isEmpty()) ? null : nameSearch.trim();
        String inputColor = (colorName.trim().isEmpty()) ? null : colorName.trim();
        String inputSize = (sizeName.trim().isEmpty()) ? null : sizeName.trim();
        String sort2 = (sort.trim().isEmpty()) ? null : sort.trim();

        Pageable pageable = null;

        if (sort2 != null) {
            if (sort2.equals("sortPrice")) {
                pageable = PageRequest.of(page, size, Sort.by( "price"));
//            } else {
//                pageable = PageRequest.of(page, size, Sort.by( "creatAt"));
            }
        } else {
            pageable = PageRequest.of(page, size);
        }
        Page<ProductDetail> products = productDetailService.findDistinctByFilters(
                name, minPrice, maxPriceCover, inputColor, inputSize, direction, pageable
        );

        return ResponseEntity.ok(products);
    }
}
