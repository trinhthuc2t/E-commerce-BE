package ecommerce.repository;

import ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepo extends JpaRepository<Category,Long> {
    Optional<Category> findById(Long id);
}
