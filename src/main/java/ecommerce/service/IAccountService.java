package ecommerce.service;

import ecommerce.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAccountService extends UserDetailsService {
    void add(Account account);
}
