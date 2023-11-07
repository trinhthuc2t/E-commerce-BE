package ecommerce.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl ;
    @ManyToOne Product product;
}
