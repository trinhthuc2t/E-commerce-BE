package ecommerce.controller;

import ecommerce.entity.Account;
import ecommerce.service.IAccountService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/accounts")

public class AccountController {
    @Qualifier("accountService")
    private IAccountService accountService;



    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account){
       if (accountService.checkRegister(account)==null) {
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(account,HttpStatus.OK);
    }

}
