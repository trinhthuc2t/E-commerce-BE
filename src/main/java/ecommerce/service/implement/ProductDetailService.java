package ecommerce.service.implement;

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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductDetailService implements IProductDetailService {
    private final IProductDetailRepo productDetailRepo;

    @Override
    public List<ProductDetail> findByProductId(Long id) {
        return productDetailRepo.findByProductId(id);
    }

    @Override
    public Optional<ProductDetail> findByProductIdAndColorProductIdAndSizeProductId(Long productId, Integer colorId, Integer sizeId) {
        return productDetailRepo.findByProductIdAndColorProductIdAndSizeProductId(productId,colorId,sizeId);
    }

    @Override
    public Optional<ProductDetail> findById(Long id) {
        return productDetailRepo.findById(id);
    }


//

//
//    public Page<ProductDetail> getAllProductDetail(Long categoryId, Pageable pageable) {
//        Set<Product> products = productRepo.getByCategoryId(categoryId);
//        List<ProductDetail> productDetails = products.stream()
//                .map(Product::getProductDetail)
//                .distinct().collect(Collectors.toList());
//        int start = (int) pageable.getOffset();
//        int end = Math.min((start + pageable.getPageSize()), productDetails.size());
//
//        return new PageImpl<>(productDetails.subList(start, end), pageable, productDetails.size());
//    }
}
