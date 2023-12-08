package ecommerce.repository;

import ecommerce.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IImageRepo extends JpaRepository<Image,Long> {
    List<Image> findByProductId(Long id);
}