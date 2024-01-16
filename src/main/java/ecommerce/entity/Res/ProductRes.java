package ecommerce.entity.Res;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRes {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private int quantity;
}
