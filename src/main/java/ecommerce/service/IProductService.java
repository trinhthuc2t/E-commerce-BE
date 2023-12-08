package ecommerce.service;

import ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IProductService {
    Page<Product> getAll(Pageable pageable);
    Page<Product> findByCategoryId(Long id, Pageable pageable);
    Optional<Product> findById(Long id);
    Page<Product> findByNameContaining(String name, Pageable pageable);
    Page<Product> findByAll( String nameSearch, Double minPrice, Double maxPrice, String colorId, String sizeId,Pageable pageable);
//    Page<Product> findByNameAndPriceAndSize( String nameSearch, Double minPrice, Double maxPrice, Long sizeId,Pageable pageable);
//    Page<Product> findByNameAndPriceAndColor( String nameSearch, Double minPrice, Double maxPrice, Long colorId,Pageable pageable);
//    Page<Product> findByNameAndPrice( String nameSearch, Double minPrice, Double maxPrice,Pageable pageable);
}
