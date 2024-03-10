package ecommerce.service.implement;

import ecommerce.entity.Oder;
import ecommerce.repository.IOderRepo;
import ecommerce.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OderService implements IOderService {
    @Autowired
    IOderRepo oderRepo;
    @Override
    public Oder save(Oder oder) {
        return oderRepo.save(oder);
    }
}
