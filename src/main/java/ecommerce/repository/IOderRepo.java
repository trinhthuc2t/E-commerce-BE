package ecommerce.repository;

import ecommerce.entity.Oder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOderRepo extends JpaRepository<Oder, Long> {

}
