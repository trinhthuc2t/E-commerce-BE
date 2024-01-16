package ecommerce.repository;
import ecommerce.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IReviewRepo extends JpaRepository<Review, Long> {
    Page<Review> findByProductId(Long productId, Pageable pageable);
    @Query (nativeQuery = true, value = " select avg(rating) as avgRate from review where product_id = :productId " )
    Double avgRate (@Param("productId") Long id);
}
