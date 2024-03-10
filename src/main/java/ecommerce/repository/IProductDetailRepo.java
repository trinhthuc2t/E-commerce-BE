package ecommerce.repository;

import ecommerce.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProductDetailRepo extends JpaRepository<ProductDetail, Long> {
    List<ProductDetail> findByProductId(Long id);

Optional<ProductDetail> findByProductIdAndColorProductIdAndSizeProductId(Long productId, Integer colorId, Integer sizeId);
    @Query(nativeQuery = true, value =
            "select * " +
                    "from product_detail pd " +
                    "         join product p on p.product_detail_id = pd.id " +
                    "         join color_product cp on cp.id = p.color_product_id " +
                    "         join size_product sp on sp.id = p.size_product_id " +
                    "where product_detail_id = :productId " +
                    "    and ((size_product_id = :sizeId " +
                    "   or :sizeId is null) " +
                    "   or size_product_id is null) " +
                    "    and ((color_product_id = :colorId " +
                    "   or :colorId is null) " +
                    "   or color_product_id is null)"

    )
    List<ProductDetail> productById(
            @Param("productId") Long productId,
            @Param("sizeId") Integer sizeId,
            @Param("colorId") Integer colorId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT DISTINCT pd.name, pd.* " +
//                    "FROM product_detail AS pd " +
//                    "         JOIN product AS p ON pd.id = p.product_detail_id " +
//                    "         JOIN color_product AS cp ON cp.id = p.color_product_id " +
//                    "         JOIN size_product AS zp ON p.size_product_id = zp.id " +
//                    "WHERE account_id = :accountId" +
//                    " AND (pd.name LIKE CONCAT('%', :nameSearch, '%') OR :nameSearch IS NULL) " +
//                    "  AND (cp.name = :colorId OR :colorId IS NULL) " +
//                    "  AND (zp.name = :sizeId OR :sizeId IS NULL) "
//
//    )
//    Page<ProductDetail> findByUserId(
//            @Param("accountId") Long accountId,
//            @Param("nameSearch") String nameSearch,
//            @Param("colorId") int colorId,
//            @Param("sizeId") int sizeId,
//            Pageable pageable
//    );
//

}
