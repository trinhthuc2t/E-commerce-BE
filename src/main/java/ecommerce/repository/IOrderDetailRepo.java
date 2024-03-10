package ecommerce.repository;

import ecommerce.entity.OrderDetail;
import ecommerce.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderDetailRepo extends JpaRepository<OrderDetail, Long> {


}
