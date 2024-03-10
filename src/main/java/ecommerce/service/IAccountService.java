package ecommerce.service;

import ecommerce.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    void add(Account account);
    Account findById(Long id);
    List<Account> findByUsernameContaining(String userName);
    Account editAccount(Long id, Account updatedAccount);
    Account checkRegister(Account account);
    boolean checkUser(String username);
    boolean checkEmail(String email);
    Account checkLogin(String username, String password);
}
