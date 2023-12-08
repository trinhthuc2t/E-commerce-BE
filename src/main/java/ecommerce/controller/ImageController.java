package ecommerce.controller;
import ecommerce.entity.Image;
import ecommerce.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    IImageService imageService;

    @GetMapping("/{id}")
    public List<Image> getProductById(@PathVariable Long id) {
        return imageService.findByProductId(id);
    }
}
