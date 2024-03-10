package ecommerce.entity.Req;

import ecommerce.entity.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
public class CartReq {
    private double total;
    private LocalDateTime orderDate;
    private String status;
    private String shippingAddress;
    private LocalDateTime createdAt;
    List<ProductDetail> products;

}
