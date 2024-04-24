package ecommerce.service;
import ecommerce.entity.ProductDetail;
import ecommerce.entity.Req.ProductDetailReq;

import java.util.List;
import java.util.Optional;

public interface IProductDetailService {
    List<ProductDetail> findByProductId(Long id);
    ProductDetail save(Long id, ProductDetailReq productDetailReq);
    void deleteProduct(Long id);

    Optional<ProductDetail> findByProductIdAndColorProductIdAndSizeProductId(Long productId, Integer colorId, Integer sizeId);
    Optional<ProductDetail> findById (Long Id);
//    ProductDetailReq save (Long Id, ProductDetailReq productDetailReq);
}
