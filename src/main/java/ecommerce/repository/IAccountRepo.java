package ecommerce.repository;

import ecommerce.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAccountRepo extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
    @Query (nativeQuery = true, value = "SELECT * FROM account WHERE username =:username AND password = :password")
    Account checkLogin (@Param("username") String username, @Param("password") String password);
}
