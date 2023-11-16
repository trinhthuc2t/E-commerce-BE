package ecommerce.service.implement;

import ecommerce.entity.Category;
import ecommerce.repository.ICategoryRepo;
import ecommerce.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepo categoryRepo;

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }
}
