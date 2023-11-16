package ecommerce.controller;
import ecommerce.entity.Category;
import ecommerce.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public List<Category> getAllProducts() {
        return categoryService.getAll();

    }
}
