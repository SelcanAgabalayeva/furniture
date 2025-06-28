package az.edu.itbrains.furniture.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private Long id;
    private String username;
    private String email;
    private String password;
}
