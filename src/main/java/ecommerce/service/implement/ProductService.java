package ecommerce.service.implement;
import ecommerce.entity.Product;
import ecommerce.repository.IProductRepo;
import ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepo productRepo;
    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }
}
