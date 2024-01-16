package ecommerce.service.implement;

import ecommerce.entity.Image;
import ecommerce.repository.IImageRepo;
import ecommerce.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageService implements IImageService {
    @Autowired
    IImageRepo imageRepo;
    @Override
    public List<Image> findByProductId(Long id) {
        return imageRepo.findByProductId(id);
    }
}
