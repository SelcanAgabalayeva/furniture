package az.edu.itbrains.furniture.controllers;

import az.edu.itbrains.furniture.dtos.ProductDto;
import az.edu.itbrains.furniture.models.Product;
import az.edu.itbrains.furniture.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    private String index(Model model){
        List<ProductDto>productDtoList=productService.getAllProducts();
        model.addAttribute("products",productDtoList);
        return "index.html";
    }
    @GetMapping("/shop")
    private String shop(Model model){
        List<ProductDto>productDtoList=productService.getAllProducts();
        model.addAttribute("products",productDtoList);
        return "shop.html";
    }
    @GetMapping("/about")
    private String about(){
        return "about.html";
    }
    @GetMapping("/blog")
    private String blog(){
        return "blog.html";
    }
    @GetMapping("/cart")
    private String cart(){
        return "cart.html";
    }

    @GetMapping("/checkout")
    private String checkout(){
        return "checkout.html";
    }
    @GetMapping("/contact")
    private String contact(){
        return "contact.html";
    }
    @GetMapping("/services")
    private String services(Model model){
        List<ProductDto>productDtoList=productService.getAllProducts();
        model.addAttribute("products",productDtoList);
        return "services.html";
    }
    @GetMapping("/thankyou")
    private String thankyou(){
        return "thankyou.html";
    }

}
