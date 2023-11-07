package ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
   private Long cardNumber ;
    private LocalDate expiration_Date;
    @OneToOne
    private Account customer;
}
