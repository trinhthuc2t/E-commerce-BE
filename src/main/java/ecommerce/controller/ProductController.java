package ecommerce.controller;

import ecommerce.entity.Product;
import ecommerce.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<Product> getAllProducts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "24") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.getAll(pageable);
    }

    @GetMapping("/category/{id}")
    public Page<Product> getAllProductsByCategory(@PathVariable Long id,
                                                  @RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "size", defaultValue = "24") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.findByCategoryId(id, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByName(@RequestParam("nameSearch") String name,
                                          @RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "24") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productService.findByNameContaining(name, pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search-all")
    public ResponseEntity<?> findByAll(@RequestParam("nameSearch") String nameSearch,
                                       @RequestParam( "minPrice") double minPrice,
                                       @RequestParam("maxPrice") double maxPrice,
                                       @RequestParam( "colorName") String colorName,
                                       @RequestParam( "sizeName") String sizeName,
                                       @RequestParam(value = "page", defaultValue = "0") int page,
                                       @RequestParam(value = "size", defaultValue = "24") int size) {
        double maxPriceCover = (maxPrice != 0) ? maxPrice : Double.MAX_VALUE;
        String name = (nameSearch.trim().isEmpty()) ? null : nameSearch;
        String inputColor = (colorName.trim().isEmpty()) ? null : colorName;
        String inputSize = (sizeName.trim().isEmpty()) ? null : sizeName;
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productService.findByAll(name, minPrice, maxPriceCover, inputColor, inputSize, pageable);
        return ResponseEntity.ok(products);

    }
}
