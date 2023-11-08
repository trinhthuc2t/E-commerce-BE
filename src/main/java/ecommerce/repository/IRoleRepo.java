package ecommerce.repository;

import ecommerce.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
