package az.edu.itbrains.furniture.repositories;

import az.edu.itbrains.furniture.models.Cart;
import az.edu.itbrains.furniture.models.Product;
import az.edu.itbrains.furniture.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByUserUsername(String username);


    Cart findByUserUsernameAndProductId(String username, Long productId);

    Cart findByUserAndProduct(User user, Product product);

}
