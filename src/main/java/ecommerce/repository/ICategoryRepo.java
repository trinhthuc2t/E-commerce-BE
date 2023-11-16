package ecommerce.repository;

import ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Long> {
}
