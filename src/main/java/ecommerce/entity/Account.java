package ecommerce.entity;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String avatar;
    private double wallet;
    private String status;
    private String address;
    private String province;
    private String district;
    private String ward;
    @ManyToOne
    private Role role;
}
