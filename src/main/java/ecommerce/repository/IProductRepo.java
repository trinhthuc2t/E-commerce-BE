package ecommerce.repository;
import ecommerce.entity.ColorProduct;
import ecommerce.entity.Product;
import ecommerce.entity.ProductDetail;
import ecommerce.entity.SizeProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.Set;

public interface IProductRepo extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryId(Long id, Pageable pageable);

    Optional<Product> findById(Long id);

    @Query(nativeQuery = true, value =
            "SELECT DISTINCT pd.* " +
                    "FROM product_detail pd " +
                    "JOIN product p ON pd.id = p.product_detail_id " +
                    "JOIN color_product cp ON cp.id = p.color_product_id " +
                    "JOIN size_product zp ON p.size_product_id = zp.id " +
                    "WHERE " +
                    "(pd.price BETWEEN :minPrice AND :maxPrice) " +
                    "AND (pd.name = :nameSearch OR :nameSearch IS NULL) " +
                    "AND (cp.name = :colorName OR :colorName IS NULL) " +
                    "AND (zp.name = :sizeName OR :sizeName IS NULL)")

    Page<ProductDetail> findByAll(@Param("nameSearch") String nameSearch,
                                  @Param("minPrice") double minPrice,
                                  @Param("maxPrice") double maxPrice,
                                  @Param("colorName") String colorName,
                                  @Param("sizeName") String sizeName,
                                  Pageable pageable);
    Set<Product> findAllByColorProductInAndSizeProductIn(Set<ColorProduct> colors, Set<SizeProduct> sizes);

    Set<Product> findAllByColorProductIn(Set<ColorProduct> colors);

    Set<Product> findAllBySizeProductIn(Set<SizeProduct> sizes);

    Set<Product> findAllBySizeProduct(SizeProduct sizeProduct);
    Set<Product> findAllByColorProduct(ColorProduct colorProduct);
    Set<Product>findAllBySizeProductAndColorProduct(SizeProduct sizeProduct, ColorProduct colorProduct);

    Set<Product> getByCategoryId(Long categoryId);
    @Query(nativeQuery = true, value =
            "select * from product p join  product_detail pd on pd.id = p.product_detail_id where account_id = :accountId ")
    Page<Product> findByUserId(@Param("accountId") Long accountId, Pageable pageable);


}




