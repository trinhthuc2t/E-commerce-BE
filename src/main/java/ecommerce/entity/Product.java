package ecommerce.entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private LocalDateTime creatAt;
    private LocalDateTime updateAt;
    @ManyToOne
    private ProductDetail productDetail;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Account account;
    @ManyToOne
    private ColorProduct colorProduct;
    @ManyToOne
    private SizeProduct sizeProduct;
}
