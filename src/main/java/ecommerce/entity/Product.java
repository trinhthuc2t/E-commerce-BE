package ecommerce.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String thumbnail;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Account account;
}
