package ecommerce.service.implement;

import ecommerce.entity.Account;
import ecommerce.entity.Role;
import ecommerce.repository.IAccountRepo;
import ecommerce.repository.IRoleRepo;
import ecommerce.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepo accountRepo;
    @Autowired
    private IRoleRepo roleRepo;

    @Override
    public void add(Account account) {
        accountRepo.save(account);
    }

    @Override
    public Account checkRegister(Account account) {
        Account account1 = accountRepo.findByUsername(account.getUsername());
        if (account1 != null || account.getPassword().isEmpty()) {
            return null;
        } else {
            Role role = roleRepo.findByName("ROLE_USER");
            account.setRole(role);
            account.setStatus("Đang hoạt động");
            return accountRepo.save(account);
        }
    }

    @Override
    public boolean checkUser(String username) {
        Account account = accountRepo.findByUsername(username);
        return account != null;
    }

    @Override
    public boolean checkEmail(String email) {
        Account account = accountRepo.findByUsername(email);
        return account != null;
    }

    @Override
    public Account checkLogin(String username, String password) {
        return accountRepo.checkLogin(username,password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUsername(), account.getPassword(), roles);
    }
}
