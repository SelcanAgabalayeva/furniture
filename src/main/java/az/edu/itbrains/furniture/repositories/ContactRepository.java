package az.edu.itbrains.furniture.repositories;

import az.edu.itbrains.furniture.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
