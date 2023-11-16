package ecommerce.repository;

import ecommerce.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepo extends JpaRepository<Account, Long> {
    Account findByUsername(String username);


}
