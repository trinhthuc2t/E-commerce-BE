package ecommerce.service.implement;
import ecommerce.entity.Account;
import ecommerce.repository.IAccountRepo;
import ecommerce.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepo accountRepo;

    @Override
    public void add(Account account) {
        accountRepo.save(account);
    }
}
