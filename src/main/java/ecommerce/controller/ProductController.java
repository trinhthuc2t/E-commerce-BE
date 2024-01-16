package ecommerce.controller;

import ecommerce.entity.Product;
import ecommerce.entity.ProductDetail;
import ecommerce.repository.IProductRepo;
import ecommerce.service.IProductDetailService;
import ecommerce.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;
    private final IProductDetailService productDetailService;


    //    @GetMapping
//    public Page<ProductDetail> getAllProducts(
//            @RequestParam(value = "page", defaultValue = "0") int page,
//            @RequestParam(value = "size", defaultValue = "100") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return productService.getAllProductDetail(pageable);
//    }

//    @GetMapping("/category/{id}")
//    public Page<ProductDetail> getAllProductsByCategory(@PathVariable Long id,
//                                                        @RequestParam(value = "page", defaultValue = "0") int page,
//                                                        @RequestParam(value = "size", defaultValue = "24") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return productDetailService.getAllProductDetail(id, pageable);
//    }
//
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductDetail(@PathVariable Long id, @RequestParam Integer colorId, @RequestParam Integer sizeId) {
        if (sizeId == 0) sizeId = null;
        if (colorId == 0) colorId = null;
        return ResponseEntity.ok(productDetailService.findByProductIdAndColorProductIdAndSizeProductId(id, colorId, sizeId));
    }

    @GetMapping("/by-owner/{accountId}")
    public ResponseEntity<?> getProductByUser(@PathVariable Long accountId,
                                              @RequestParam(value = "colorId") Integer colorId,
                                              @RequestParam(value = "sizeId") Integer sizeId,
                                              @RequestParam(value = "nameSearch") String nameSearch,
                                              @RequestParam(value = "page", defaultValue = "0") int page,
                                              @RequestParam(value = "size", defaultValue = "24") int size) {
        if (colorId == 0) colorId = null;
        if (sizeId == 0) sizeId = null;
        if (nameSearch.trim().isEmpty()) nameSearch = null;
        Pageable pageable = PageRequest.of(page, size);
        Page<IProductRepo.ProductCZ> products = productService.findByUserId(accountId, colorId, sizeId, nameSearch ,pageable);
        return ResponseEntity.ok(products);
    }


    @GetMapping("/search-all")
    public ResponseEntity<?> findByAll(
            @RequestParam("nameSearch") String nameSearch,
            @RequestParam("minPrice") Double minPrice,
            @RequestParam("maxPrice") Double maxPrice,
            @RequestParam("colorId") Integer colorId,
            @RequestParam("sizeId") Integer sizeId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "24") int size,
            @RequestParam(value = "sort", defaultValue = "") String sort,
            @RequestParam(value = "direction", defaultValue = "asc") String direction
    ) {
        double maxPriceCover = (maxPrice != 0) ? maxPrice : Double.MAX_VALUE;
        Integer inputColor = (colorId != 0) ? colorId : null;
        Integer inputSize = (sizeId != 0) ? sizeId : null;
        String name = (nameSearch.trim().isEmpty()) ? null : nameSearch.trim();

        String sort2 = (sort.trim().isEmpty()) ? null : sort.trim();
        Pageable pageable = null;

        if (sort2 != null) {
            if (sort2.equals("sortPrice")) {
                pageable = PageRequest.of(page, size, Sort.by("price"));
//            } else {
//                pageable = PageRequest.of(page, size, Sort.by( "creatAt"));
            }
        } else {
            pageable = PageRequest.of(page, size);
        }
        Page<Product> products = productService.findDistinctByFilters(
                name, minPrice, maxPriceCover, inputColor, inputSize, direction, pageable
        );

        return ResponseEntity.ok(products);
    }
}
