package ecommerce.controller;

import ecommerce.entity.Account;
import ecommerce.entity.Res.AccountToken;
import ecommerce.service.IAccountService;
import ecommerce.service.implement.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    AuthenticationManager authenticate;
    @Autowired
    JwtService jwtService;


    @PostMapping("/login")
    public AccountToken checkLogin(@RequestBody Account account) {
        Authentication authentication = authenticate.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        account = accountService.checkLogin(account.getUsername(), account.getPassword());
        String token = jwtService.createToken(authentication);
        AccountToken accountToken = new AccountToken(account.getId(), account.getUsername(), token, account.getFirstname(), account.getLastname(), account.getAddress(),
                account.getEmail(), account.getPhone(), account.getAvatar(), account.getWallet(), account.getStatus(), account.getRole(), account.getProvince(), account.getDistrict(), account.getWard());
        return accountToken;
    }

    @GetMapping("/login/check-username")
    public boolean checkUsername(@RequestParam("username") String username) {
        return accountService.checkUser(username);
    }

    @GetMapping("/login/check-email")
    public boolean checkEmail(@RequestParam("email") String email) {
        return accountService.checkEmail(email);
    }
}
