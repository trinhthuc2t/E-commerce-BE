package ecommerce.service.implement;

import ecommerce.entity.SizeProduct;
import ecommerce.repository.ISizeRepo;
import ecommerce.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeService implements ISizeService {
    @Autowired
    ISizeRepo sizeRepo;
    @Override
    public List<SizeProduct> listSize() {
        return sizeRepo.findAll() ;
    }
}
