package az.edu.itbrains.furniture.dtos.testimonial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialDashboardDto {
    private Long id;
    private String name;
    private String photoUrl;
    private String description;
    private String work;
}
