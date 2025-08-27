package az.edu.itbrains.furniture.controllers;

import az.edu.itbrains.furniture.dtos.testimonial.TestimonialDto;
import az.edu.itbrains.furniture.dtos.product.ProductDto;
import az.edu.itbrains.furniture.services.ProductService;
import az.edu.itbrains.furniture.services.TestimonialService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;
    private final TestimonialService testimonialService;

    public HomeController(ProductService productService, TestimonialService testimonialService) {
        this.productService = productService;
        this.testimonialService = testimonialService;
    }

    @GetMapping("/")
    private String index(Model model){
        List<ProductDto>productDtoList=productService.getAllProducts();
        model.addAttribute("products",productDtoList);
        List<TestimonialDto>testimonialList=testimonialService.getAllTestimonial();
        model.addAttribute("testimonials",testimonialList);
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
    @GetMapping("/product/{id}")
    private String detail(@PathVariable Long id,Model model){
        ProductDto productDto=productService.getProductById(id);
        model.addAttribute("product",productDto);
        return "detail.html";
    }

}
