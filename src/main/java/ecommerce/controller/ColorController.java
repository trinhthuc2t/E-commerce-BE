package ecommerce.controller;

import ecommerce.entity.ColorProduct;
import ecommerce.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/color")
public class ColorController {
    @Autowired
    IColorService colorService;
    @GetMapping("")
    List<ColorProduct> colorProductList (){
        return colorService.listColor();
    }
}
