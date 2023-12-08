package ecommerce.service.implement;
import ecommerce.entity.Product;
import ecommerce.repository.IProductRepo;
import ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepo productRepo;
    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public Page<Product> findByCategoryId(Long id, Pageable pageable) {
        return productRepo.findByCategoryId(id, pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    public Page<Product> findByNameContaining(String name, Pageable pageable) {
        return productRepo.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Product> findByAll(String nameSearch, Double minPrice, Double maxPrice, String colorName, String sizeName,Pageable pageable) {
        return productRepo.findByAll(nameSearch,minPrice,maxPrice,colorName,sizeName, pageable);
    }

//    @Override
//    public Page<Product> findByNameAndPriceAndSize(String nameSearch, Double minPrice, Double maxPrice, Long sizeId, Pageable pageable) {
//        return productRepo.findByNameAndPriceAndSize(nameSearch, minPrice, maxPrice, sizeId, pageable);
//    }
//
//    @Override
//    public Page<Product> findByNameAndPriceAndColor(String nameSearch, Double minPrice, Double maxPrice, Long colorId, Pageable pageable) {
//        return productRepo.findByNameAndPriceAndColor(nameSearch, minPrice, maxPrice, colorId, pageable);
//    }
//
//    @Override
//    public Page<Product> findByNameAndPrice(String nameSearch, Double minPrice, Double maxPrice, Pageable pageable) {
//        return productRepo.findByNameAndPrice(nameSearch, minPrice, maxPrice, pageable);
//    }
}
