package ecommerce.controller;

import ecommerce.entity.Product;
import ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(value = "page", defaultValue = "0") int page,
                                        @RequestParam(value = "size", defaultValue = "24") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.getAll(pageable);

    }
}
