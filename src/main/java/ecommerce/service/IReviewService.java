package ecommerce.service;

import ecommerce.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReviewService {
    Page<Review> findByProductId(Long productId, Pageable pageable);
    Double avgRate (Long id);


}
