package ecommerce.repository;
import ecommerce.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductDetailRepo extends JpaRepository<ProductDetail, Long> {
    @Query(nativeQuery = true, value =
            "SELECT DISTINCT pd.name, pd.* " +
                    "FROM product_detail AS pd " +
                    "         JOIN product AS p ON pd.id = p.product_detail_id " +
                    "         JOIN color_product AS cp ON cp.id = p.color_product_id " +
                    "         JOIN size_product AS zp ON p.size_product_id = zp.id " +
                    "WHERE (pd.price BETWEEN :minPrice AND :maxPrice) " +
                    "  AND (pd.name LIKE CONCAT('%', :nameSearch, '%') OR :nameSearch IS NULL) " +
                    "  AND (cp.name = :colorId OR :colorId IS NULL) " +
                    "  AND (zp.name = :sizeId OR :sizeId IS NULL) "

    )
    Page<ProductDetail> findDistinctByFilters(
            @Param("nameSearch") String nameSearch,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("colorId") String colorId,
            @Param("sizeId") String sizeId,
            Pageable pageable
    );


@Query(nativeQuery = true,value =
        "SELECT DISTINCT pd.name, pd.name, pd.* FROM product_detail as pd " +
                "JOIN product as p ON pd.id = p.product_detail_id " +
                "JOIN category as cg on p.category_id = cg.id " +
                "where cg.id = :categoryId")
    Page<ProductDetail> getProductByCategoryId(@Param("categoryId") Long id, Pageable pageable);

}
