package ecommerce.service.implement;
import ecommerce.entity.Product;
import ecommerce.entity.ProductDetail;
import ecommerce.repository.IProductDetailRepo;
import ecommerce.repository.IProductRepo;
import ecommerce.service.IProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductDetailService implements IProductDetailService {
    private final IProductDetailRepo productDetailRepo;
    private final IProductRepo productRepo;


    @Override
    public Page<ProductDetail> getProductByCategoryId(Long id, Pageable pageable) {
        return productDetailRepo.getProductByCategoryId(id, pageable);
    }

    @Override
    public Page<ProductDetail> findDistinctByFilters(String nameSearch, double minPrice, double maxPrice, String colorName, String sizeName, String direction, Pageable pageable) {
        return productDetailRepo.findDistinctByFilters(nameSearch,minPrice,maxPrice,colorName,sizeName,pageable);
    }



    public Page<ProductDetail> getAllProductDetail(Long categoryId, Pageable pageable){
       Set<Product> products = productRepo.getByCategoryId(categoryId);
       List<ProductDetail> productDetails = products.stream()
               .map(Product::getProductDetail)
               .distinct().collect(Collectors.toList());
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), productDetails.size());

        return new PageImpl<>(productDetails.subList(start, end), pageable, productDetails.size());
    }
}
