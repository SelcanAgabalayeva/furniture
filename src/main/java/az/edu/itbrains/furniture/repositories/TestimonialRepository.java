package az.edu.itbrains.furniture.repositories;

import az.edu.itbrains.furniture.models.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialRepository extends JpaRepository<Testimonial,Long> {
}
