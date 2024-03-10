package ecommerce.service;
import ecommerce.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductDetailService {
    List<ProductDetail> findByProductId(Long id);

    Optional<ProductDetail> findByProductIdAndColorProductIdAndSizeProductId(Long productId, Integer colorId, Integer sizeId);
    Optional<ProductDetail> findById (Long Id);
}
