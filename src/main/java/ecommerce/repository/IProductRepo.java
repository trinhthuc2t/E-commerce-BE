package ecommerce.repository;

import ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IProductRepo extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryId(Long id, Pageable pageable);

    Optional<Product> findById(Long id);

    Page<Product> findByNameContaining(String name, Pageable pageable);


    @Query(nativeQuery = true, value =
            "SELECT * FROM product AS p " +
                    "JOIN color_product cp ON cp.id = p.color_product_id " +
                    "JOIN size_product zp ON p.size_product_id = zp.id " +
                    "WHERE " +
                    "((p.name LIKE %:nameSearch%) OR (:nameSearch IS NULL)) " +
                    "AND (p.price BETWEEN :minPrice AND :maxPrice) " +
                    "AND ((cp.name = :colorName) OR (:colorName IS NULL) OR (cp.name is null)) " +
                    "AND ((zp.name = :sizeName) OR (:sizeName IS NULL) or (cp.name is null))")
    Page<Product> findByAll(@Param("nameSearch") String nameSearch,
                                     @Param("minPrice") Double minPrice,
                                     @Param("maxPrice") Double maxPrice,
                                     @Param("colorName") String colorName,
                                     @Param("sizeName") String sizeName,
                                     Pageable pageable);
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM product AS p " +
//                    "JOIN color_product cp ON cp.id = p.color_product_id " +
//                    "JOIN size_product zp ON p.size_product_id = zp.id " +
//                    "WHERE " +
//                    "((p.name LIKE %:nameSearch%) OR (p.name IS NULL)) " +
//                    "AND (p.price BETWEEN :minPrice AND :maxPrice) " +
//                    "AND ((zp.id = :sizeId) OR (zp.id IS NULL))")
//    Page<Product> findByNameAndPriceAndSize(@Param("nameSearch") String nameSearch,
//                                     @Param("minPrice") Double minPrice,
//                                     @Param("maxPrice") Double maxPrice,
//                                     @Param("sizeId") Long size,
//                                     Pageable pageable);
//
//  @Query(nativeQuery = true, value =
//            "SELECT * FROM product AS p " +
//                    "JOIN color_product cp ON cp.id = p.color_product_id " +
//                    "JOIN size_product zp ON p.size_product_id = zp.id " +
//                    "WHERE " +
//                    "((p.name LIKE %:nameSearch%) OR (p.name IS NULL)) " +
//                    "AND (p.price BETWEEN :minPrice AND :maxPrice) " +
//                    "AND ((cp.id = :colorId) OR (cp.id IS NULL))")
//    Page<Product> findByNameAndPriceAndColor(@Param("nameSearch") String nameSearch,
//                                     @Param("minPrice") Double minPrice,
//                                     @Param("maxPrice") Double maxPrice,
//                                     @Param("colorId") Long colorId,
//                                     Pageable pageable);
//
//  @Query(nativeQuery = true, value =
//            "SELECT * FROM product AS p " +
//                    "JOIN color_product cp ON cp.id = p.color_product_id " +
//                    "JOIN size_product zp ON p.size_product_id = zp.id " +
//                    "WHERE " +
//                    "((p.name LIKE %:nameSearch%) OR (p.name IS NULL)) " +
//                    "AND (p.price BETWEEN :minPrice AND :maxPrice) ")
//    Page<Product> findByNameAndPrice(@Param("nameSearch") String nameSearch,
//                                     @Param("minPrice") Double minPrice,
//                                     @Param("maxPrice") Double maxPrice,
//                                     Pageable pageable);


}




