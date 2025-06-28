package az.edu.itbrains.furniture.services.Impls;

import az.edu.itbrains.furniture.dtos.ContactDto;
import az.edu.itbrains.furniture.models.Contact;
import az.edu.itbrains.furniture.repositories.ContactRepository;
import az.edu.itbrains.furniture.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    @Override
    public void addContact(ContactDto contactDto) {
        Contact contact=new Contact();
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setEmail(contactDto.getEmail());
        contact.setMessage(contactDto.getMessage());
        contactRepository.save(contact);

    }
}
