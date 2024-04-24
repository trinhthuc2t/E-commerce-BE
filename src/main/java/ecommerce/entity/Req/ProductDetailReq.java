package ecommerce.entity.Req;

import ecommerce.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailReq {
    String name;
    String description;
    Double price;
    String thumbnail;
    int quantity;
    int color;
    int size;
    Long category;
    List<Image> images;
}
