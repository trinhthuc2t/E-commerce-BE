package ecommerce.controller;
import ecommerce.entity.Account;
import ecommerce.entity.dto.AccountToken;
import ecommerce.service.IAccountService;
import ecommerce.service.implement.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account){
       if (accountService.checkRegister(account)==null) {
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @GetMapping ("/check-username")
    public boolean checkUser (@RequestParam String username){
       return accountService.checkUser(username);
    }

    @GetMapping("/check-email")
    public boolean checkEmail(@RequestParam String email) {
        return accountService.checkEmail(email);
    }

}