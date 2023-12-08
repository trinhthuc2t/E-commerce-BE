package ecommerce.service.implement;

import ecommerce.repository.IImageRepo;
import ecommerce.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Image implements IImageService {
    @Autowired
    IImageRepo imageRepo;
    @Override
    public List<ecommerce.entity.Image> findByProductId(Long id) {
        return imageRepo.findByProductId(id);
    }
}
