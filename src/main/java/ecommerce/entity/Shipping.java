package ecommerce.entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carrier;
    private String trackingNumber;
    private String status;
    private LocalDateTime estimatedDeliveryDate;
    @ManyToOne
    private Oder oder;
}
