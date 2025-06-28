package az.edu.itbrains.furniture.repositories;

import az.edu.itbrains.furniture.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
