package az.edu.itbrains.furniture.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {
    private String name;
    private String photoUrl;
    private Double price;
}
