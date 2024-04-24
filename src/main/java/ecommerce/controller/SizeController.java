package ecommerce.controller;
import ecommerce.entity.SizeProduct;
import ecommerce.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/size")
public class SizeController {
    @Autowired
    ISizeService sizeService;
    @GetMapping("")
    List<SizeProduct> colorProductList (){
        return sizeService.listSize();
    }
}
