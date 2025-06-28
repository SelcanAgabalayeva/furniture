package az.edu.itbrains.furniture.repositories;

import az.edu.itbrains.furniture.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
