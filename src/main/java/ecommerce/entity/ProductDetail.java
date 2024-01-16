package ecommerce.entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private LocalDateTime creatAt;
    private LocalDateTime updateAt;
    @ManyToOne
    private Product product;
    @ManyToOne
    private ColorProduct colorProduct;
    @ManyToOne
    private SizeProduct sizeProduct;
}
