package ecommerce.service.implement;

import ecommerce.entity.Product;
import ecommerce.entity.ProductDetail;
import ecommerce.repository.IProductRepo;
import ecommerce.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ProductService implements IProductService {

    private final IProductRepo productRepo;
//    private final IProductDetailRepo productDetailRepo;
//
//    @Override
//    public Page<ProductDetail> getAllProductDetail(Pageable pageable) {
//        return productDetailRepo.findAll(pageable);
//    }
//    @Override
//    public Optional<Product> findByProductId(Long productId, Integer colorId, Integer sizeId) {
//        return productRepo.findByProductId(productId, colorId, sizeId);
//    }
//    @Override
//    public List<ProductRes> findByProductId(Long productId, Integer colorId, Integer sizeId) {
//        List<Object[]> results = productRepo.findByProductId(productId, colorId, sizeId);
//        List<ProductRes> productResList = new ArrayList<>();
//        for (Object[] row : results) {
//            BigInteger id = (BigInteger) row[0];
//            String name = (String) row[1];
//            String description = (String) row[2];
//            Double price = (Double) row[3];
//            BigDecimal quantity = (BigDecimal) row[5];
//            ProductRes productRes = new ProductRes(id.longValue(),name,description,price,quantity.intValue());
//            productResList.add(productRes);
//        }
//        return productResList;
//    }


    @Override
    public Page<Product> findByAccountIdAndNameContaining(Long id, String name, Pageable pageable) {
        return productRepo.findByAccountIdAndNameContaining(id, name, pageable);
    }

    @Override
    public Page<IProductRepo.ProductCZ> findByUserId(Long accountId, Integer colorId, Integer sizeId , Pageable pageable) {
        return productRepo.findByUserId(accountId, colorId, sizeId, pageable);
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

//    @Override
//    public Page<Product> findDistinctByFilters(String nameSearch, double minPrice, double maxPrice, Integer colorId, Integer sizeId, String direction, Pageable pageable) {
//        return productRepo.findDistinctByFilters(nameSearch, minPrice, maxPrice, colorId, sizeId, pageable);
//    }
    public Page<Product> findDistinctByFilters(String nameSearch, double minPrice, double maxPrice, Integer colorId, Integer sizeId, String sort, String direction, int page, int size) {
        double maxPriceCover = (maxPrice != 0) ? maxPrice : Double.MAX_VALUE;
        Integer inputColor = (colorId != 0) ? colorId : null;
        Integer inputSize = (sizeId != 0) ? sizeId : null;
        String name = (nameSearch != null && !nameSearch.trim().isEmpty()) ? nameSearch.trim() : null;
        Sort sorting = null;

        if (sort != null && !sort.trim().isEmpty()) {
            if (sort.equals("sortPrice")) {
                sorting = Sort.by("price");
            } else {
                // Add other sorting options if needed
                // sorting = Sort.by("creatAt");
            }
        }

        Pageable pageable;
        if (sorting != null) {
            pageable = PageRequest.of(page, size, Sort.by(direction.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, String.valueOf(sorting)));
        } else {
            pageable = PageRequest.of(page, size, direction.equals("asc") ? Sort.by(Sort.Direction.ASC, "id") : Sort.by(Sort.Direction.DESC, "id"));
        }

        return productRepo.findDistinctByFilters(name, minPrice, maxPriceCover, inputColor, inputSize, pageable);
    }

}
