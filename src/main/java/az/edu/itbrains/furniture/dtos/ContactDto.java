package az.edu.itbrains.furniture.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private String firstName;
    private String lastName;
    private String email;
    private String message;
}
