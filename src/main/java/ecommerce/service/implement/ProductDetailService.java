package ecommerce.service.implement;

import ecommerce.entity.*;
import ecommerce.entity.Req.ProductDetailReq;
import ecommerce.repository.*;
import ecommerce.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProductDetailService implements IProductDetailService {
    private final IProductDetailRepo productDetailRepo;
    private final IAccountRepo accountRepo;
    private final IProductService productService;
    private final IColorRepo colorRepo;
    private final ISizeRepo sizeRepo;
    private final ICategoryRepo categoryRepo;
    private final IImageRepo imageRepo;

    @Override
    public List<ProductDetail> findByProductId(Long id) {
        return productDetailRepo.findByProductId(id);
    }

    @Override
    public ProductDetail save(Long id, ProductDetailReq productDetailReq) {
        Product product = new Product();
        Account account = accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản với ID: " + id));
        ColorProduct color = colorRepo.findById(productDetailReq.getColor())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy màu sản phẩm với ID: " + productDetailReq.getColor()));
        SizeProduct size = sizeRepo.findById(productDetailReq.getSize())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy kích thước sản phẩm với ID: " + productDetailReq.getSize()));
        Category category = categoryRepo.findById(productDetailReq.getCategory())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy loại sản phẩm với ID: " + productDetailReq.getCategory()));

        product.setName(productDetailReq.getName());
        product.setPrice(productDetailReq.getPrice());
        product.setThumbnail(productDetailReq.getThumbnail());
        product.setDescription(productDetailReq.getDescription());
        product.setAccount(account);
        product.setCategory(category);
        productService.save(product);


        List<Image> images = productDetailReq.getImages();
        for (Image value : images) {
            Image image = new Image();
            image.setProduct(product);
            image.setImageUrl(value.getImageUrl());
            imageRepo.save(image);
        }

        ProductDetail productDetail = new ProductDetail();
        productDetail.setQuantity(productDetailReq.getQuantity());
        productDetail.setCreatAt(LocalDateTime.now());
        productDetail.setUpdateAt(LocalDateTime.now());
        productDetail.setProduct(product);
        productDetail.setColorProduct(color);
        productDetail.setSizeProduct(size);



        return productDetailRepo.save(productDetail);
    }


    @Override
    public Optional<ProductDetail> findByProductIdAndColorProductIdAndSizeProductId(Long productId, Integer colorId, Integer sizeId) {
        return productDetailRepo.findByProductIdAndColorProductIdAndSizeProductId(productId, colorId, sizeId);
    }

    @Override
    public Optional<ProductDetail> findById(Long id) {
        return productDetailRepo.findById(id);
    }

//    @Override
//    public ProductDetailReq save(Long Id, ProductDetailReq productDetailReq) {
//        return null;
//    }


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
