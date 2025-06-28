package az.edu.itbrains.furniture.controllers;

import az.edu.itbrains.furniture.dtos.ContactDto;
import az.edu.itbrains.furniture.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactController {
private final ContactService contactService;
     @PostMapping("/contact")
    public String addContact(@ModelAttribute("contact") ContactDto contactDto){
         contactService.addContact(contactDto);
         return "redirect:/contact";
     }
}
