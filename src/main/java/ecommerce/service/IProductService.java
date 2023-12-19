package ecommerce.service;

import ecommerce.entity.Product;
import ecommerce.entity.ProductDetail;
import ecommerce.repository.IProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface IProductService {
    Page<Product> findByCategoryId(Long id, Pageable pageable);
    Page<Product> getAll(Pageable pageable);
     Page<ProductDetail> getAllProductDetail(Pageable pageable);
    Optional<Product> findById(Long id);

     Page<Product> findByUserId(Long accountId, Pageable pageable) ;

    Page<ProductDetail> findByAll( String nameSearch, double minPrice, double maxPrice, String colorId, String sizeId,Pageable pageable);
    public Page<ProductDetail> findPd(String nameSearch, double minPrice, double maxPrice, String colorName, String sizeName, Pageable pageable);
}
