package ecommerce.repository;

import ecommerce.entity.ColorProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface IColorRepo extends JpaRepository<ColorProduct,Integer> {
    Set<ColorProduct> findByNameIn(Set<String> name);
    Optional<ColorProduct> findByName(String name);
}
