package ecommerce.service.implement;
import ecommerce.repository.IRoleRepo;
import ecommerce.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepo roleRepo;


}
