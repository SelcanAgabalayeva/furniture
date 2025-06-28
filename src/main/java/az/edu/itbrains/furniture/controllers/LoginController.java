package az.edu.itbrains.furniture.controllers;

import az.edu.itbrains.furniture.dtos.RegisterDto;
import az.edu.itbrains.furniture.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    @GetMapping("/register")
    private String blog(){
        return "register.html";
    }
    @PostMapping("/register")
    public String register(RegisterDto registerDto){
    boolean result=userService.registerUser(registerDto);
    if(result){
        return "redirect:/register";
    }
        return "redirect:/register";
    }
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        Model model) {
        if (error != null) {
            model.addAttribute("loginError", "Kod məlumatları səhvdir.");
        }
        return "register.html";
    }
}
