package ecommerce.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    private ProductDetail productDetail;
    @ManyToOne
    private Oder oder;
}
