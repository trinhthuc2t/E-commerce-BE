package ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    private ProductDetail productDetail;
    @ManyToOne
    private Oder oder;

    public OrderDetail(int quantity, ProductDetail productDetail, Oder oder) {
        this.quantity = quantity;
        this.productDetail = productDetail;
        this.oder = oder;
    }
}
