package ecommerce.service.implement;

import ecommerce.entity.ColorProduct;
import ecommerce.entity.Product;
import ecommerce.entity.ProductDetail;
import ecommerce.entity.SizeProduct;
import ecommerce.repository.IColorRepo;
import ecommerce.repository.IProductDetailRepo;
import ecommerce.repository.IProductRepo;
import ecommerce.repository.ISizeRepo;
import ecommerce.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductService implements IProductService {

    private final IProductRepo productRepo;
    private final IProductDetailRepo productDetailRepo;
    private final IColorRepo colorRepo;
    private final ISizeRepo sizeRepo;


    @Override
    public Page<Product> findByCategoryId(Long id, Pageable pageable) {
        return productRepo.findByCategoryId(id, pageable);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public Page<ProductDetail> getAllProductDetail(Pageable pageable) {
        return productDetailRepo.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public Page<ProductDetail> findByAll(String nameSearch, double minPrice, double maxPrice, String colorId, String sizeId, Pageable pageable) {
        return null;
    }
    @Override
    public Page<Product> findByUserId(Long accountId, Pageable pageable){
        return productRepo.findByUserId(accountId,pageable);
    }


//    @Override
//    public Page<ProductDetail> findByAll(String nameSearch, double minPrice, double maxPrice, String colorName, String sizeName, Pageable pageable) {
//        return productDetailRepo.findDistinctByFilters(nameSearch, minPrice, maxPrice, colorName, sizeName, pageable);
////    }
//    @Override
//    public Page<ProductDetail> findByAll(String nameSearch, double minPrice, double maxPrice, String colorName, String sizeName, Pageable pageable) {
//        return productDetailRepo.findDistinctByFilters(nameSearch, minPrice, maxPrice, colorName, sizeName, pageable);
//    }

    public Page<ProductDetail> findPdFake(String nameSearch, double minPrice, double maxPrice, Set<String> colorName, Set<String> sizeName, Pageable pageable) {
        Set<ColorProduct> colors = colorRepo.findByNameIn(colorName);
        Set<SizeProduct> sizes = sizeRepo.findByNameIn(sizeName);
        Set<Product> products;
        if (colors.isEmpty()) products = productRepo.findAllBySizeProductIn(sizes);
        if (sizes.isEmpty()) products = productRepo.findAllByColorProductIn(colors);
        else products = productRepo.findAllByColorProductInAndSizeProductIn(colors, sizes);
        Set<ProductDetail> productDetails;
        if (!products.isEmpty()) productDetails = products.stream()
                .map(Product::getProductDetail)
                .collect(Collectors.toSet());
        else productDetails = new HashSet<>(productDetailRepo.findAll());

        List<ProductDetail> resultList = productDetails.stream()
                .filter(productDetail ->
                        productDetail.getName().toLowerCase().contains(nameSearch.toLowerCase()) // changed equals to contains
                                && productDetail.getPrice() > minPrice
                                && productDetail.getPrice() < maxPrice
                )
                .distinct().collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), resultList.size());

        return new PageImpl<>(resultList.subList(start, end), pageable, resultList.size());
    }


    public Page<ProductDetail> findPd(String nameSearch, double minPrice, double maxPrice, String colorName, String sizeName, Pageable pageable) {
        Optional<ColorProduct> colorProductOptional = colorRepo.findByName(colorName);
        Optional<SizeProduct> sizeProductOptional = sizeRepo.findByName(sizeName);
        Set<Product> products;
        if (colorProductOptional.isPresent() && sizeProductOptional.isPresent()) {
            products = productRepo.findAllBySizeProductAndColorProduct(sizeProductOptional.get()
                    , colorProductOptional.get());
        }
        else if (!colorProductOptional.isPresent() && !sizeProductOptional.isPresent()) products = new HashSet<>();
        else products = colorProductOptional.isPresent() ? productRepo.findAllByColorProduct(colorProductOptional.get())
                    : productRepo.findAllBySizeProduct(sizeProductOptional.get());

        Set<ProductDetail> productDetails;
        if (colorName == "" && sizeName == "") productDetails = new HashSet<>(productDetailRepo.findAll());
        else productDetails = products.stream()
                .map(Product::getProductDetail)// product.getProductDetail
                .collect(Collectors.toSet());

        List<ProductDetail> resultList = productDetails.stream()
                .filter(productDetail ->
                        productDetail.getName().toLowerCase().contains(nameSearch.toLowerCase()) // changed equals to contains
                                && productDetail.getPrice() > minPrice
                                && productDetail.getPrice() < maxPrice
                )
                .distinct().collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), resultList.size());

        return new PageImpl<>(resultList.subList(start, end), pageable, resultList.size());
    }

}
