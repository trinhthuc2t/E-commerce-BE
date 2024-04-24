package ecommerce.service.implement;

import ecommerce.entity.ColorProduct;
import ecommerce.repository.IColorRepo;
import ecommerce.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService implements IColorService {
    @Autowired
    IColorRepo colorRepo;

    @Override
    public List<ColorProduct> listColor() {
        return colorRepo.findAll();
    }
}
