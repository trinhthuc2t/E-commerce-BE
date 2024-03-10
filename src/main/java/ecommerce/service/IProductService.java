package ecommerce.service;

import ecommerce.entity.Product;
import ecommerce.repository.IProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    //
//    Page<Product> getAllProductDetail(Pageable pageable);
//
//
//    Optional<ProductDetail> findByProductId(Long productId, Integer colorId, Integer sizeId);
//
    Page<Product> findByAccountIdAndNameContaining(Long id, String name, Pageable pageable);

    Page<IProductRepo.ProductCZ> findByUserId(Long accountId, Integer colorId, Integer sizeId , Pageable pageable);

    Page<Product> findDistinctByFilters(
            String nameSearch, double minPrice, double maxPrice, Integer colorId, Integer sizeName,
            String direction, Pageable pageable);
}