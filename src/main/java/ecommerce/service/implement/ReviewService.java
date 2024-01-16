package ecommerce.service.implement;

import ecommerce.entity.Review;
import ecommerce.repository.IReviewRepo;
import ecommerce.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements IReviewService {
@Autowired
    IReviewRepo reviewRepo;
    @Override
    public Page<Review> findByProductId(Long productId, Pageable pageable) {
        return reviewRepo.findByProductId(productId, pageable);
    }

    @Override
    public Double avgRate(Long id) {
        return reviewRepo.avgRate(id);
    }
}
