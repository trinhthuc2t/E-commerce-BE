package ecommerce.repository;

import ecommerce.entity.Product;
import ecommerce.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface IProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    @Query(nativeQuery = true, value =
            "SELECT p.*, " +
                    "       SUM( if((pd.product_id) " +
                    "                  AND (pd.size_product_id = :sizeId OR :sizeId IS NULL) " +
                    "                  AND (pd.color_product_id = :colorId OR :colorId IS NULL), " +
                    "              pd.quantity, 0)) AS quantitySC " +
                    "FROM product_detail AS pd " +
                    "         JOIN " +
                    "     product AS p ON pd.product_id = p.id " +
                    "WHERE p.account_id = :accountId " +
                    "    and p.name like concat('%', :nameSearch, '%') or :nameSearch is null " +
                    "GROUP BY product_id")
    Page<IProductRepo.ProductCZ> findByUserId(
            @Param("accountId") Long accountId,
            @Param("colorId") Integer colorId,
            @Param("sizeId") Integer sizeId,
            @Param("nameSearch") String nameSearch,
            Pageable pageable
    );

    interface ProductCZ {
        Long getId();

        String getName();

        String getDescription();

        String getThumbnail();

        Long getQuantity();

        Long getQuantitySC();

        Double getPrice();
    };


//    Set<ProductDetail> getByCategoryId(Long categoryId);

//    @Query(nativeQuery = true, value =
//            "SELECT  pd.*, " +
//                    "       SUM(IF((p.product_detail_id) " +
//                    "                  AND (p.size_product_id = :sizeId OR :sizeId IS NULL) " +
//                    "                  AND (p.color_product_id = :colorId OR :colorId IS NULL), " +
//                    "              p.quantity, 0)) AS quantitySC " +
//                    "FROM " +
//                    "    product AS p " +
//                    "        JOIN " +
//                    "    product_detail AS pd ON pd.id = p.product_detail_id " +
//                    "WHERE " +
//                    "        p.product_detail_id = :productId " +
//                    "GROUP BY " +
//                    "    p.product_detail_id")
//    List<Object[]> findByProductId(
//            @Param("productId") Long productId,
//            @Param("colorId") Integer colorId,
//            @Param("sizeId") Integer sizeId
//    );

//    @Query(nativeQuery = true, value =
//            "select p.* from product p join product_detail pd on p.product_detail_id = pd.id " +
//                    "           where " +
//                    "              product_detail_id = :productId and size_product_id = :sizeId and color_product_id = :colorId ")
//    Optional<ProductDetail> findByProductId(
//            @Param("productId") Long productId,
//            @Param("colorId") Integer colorId,
//            @Param("sizeId") Integer sizeId
//    );


//    @Query(nativeQuery = true, value = "select distinct pd.name, pd.*  " +
//            "FROM product AS p " +
//            "         JOIN product_detail AS pd ON pd.id = p.product_detail_id " +
//            "         JOIN color_product AS cp ON cp.id = p.color_product_id " +
//            "         JOIN size_product AS zp ON p.size_product_id = zp.id " +
//            "WHERE p.account_id = :accountId " +
//            "  AND (pd.name LIKE CONCAT('%', :nameSearch, '%') OR :nameSearch IS NULL) " +
//            "group by p.product_detail_id")
//    Page<Product> findByUserId(
//            @Param("accountId") Long accountId,
//            @Param("nameSearch") String nameSearch,
//            Pageable pageable
//    );
    @Query(nativeQuery = true, value =
            "select distinct p.name, p.* " +
                    "from product p " +
                    "         join product_detail pd on p.id = pd.product_id " +
                    "where (p.price BETWEEN :minPrice AND :maxPrice) " +
                    "  and (p.name like concat('%', :nameSearch, '%') or :nameSearch is null) " +
                    "  and (pd.color_product_id = :colorId OR :colorId IS NULL) " +
                    "  AND (pd.size_product_id = :sizeId OR :sizeId IS NULL) ")
    Page<Product> findDistinctByFilters(
            @Param("nameSearch") String nameSearch,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("colorId") Integer colorId,
            @Param("sizeId") Integer sizeId,
            Pageable pageable
    );

}




