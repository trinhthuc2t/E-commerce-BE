package ecommerce.repository;


import ecommerce.entity.SizeProduct;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.Set;

public interface ISizeRepo extends JpaRepository<SizeProduct,Integer> {

    Set<SizeProduct> findByNameIn(Set<String> sizeName);
    Optional<SizeProduct> findByName(String name);
}
