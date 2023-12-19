package ecommerce.service;
import ecommerce.entity.Product;
import ecommerce.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IProductDetailService {
    Page<ProductDetail> getAllProductDetail(Long categoryId, Pageable pageable);

    Page<ProductDetail> getProductByCategoryId(Long id, Pageable pageable);

    Page<ProductDetail> findDistinctByFilters(
            String nameSearch, double minPrice, double maxPrice, String colorName, String sizeName,
             String direction, Pageable pageable);

}
