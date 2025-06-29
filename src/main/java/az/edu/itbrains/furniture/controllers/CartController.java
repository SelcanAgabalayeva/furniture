package az.edu.itbrains.furniture.controllers;

import az.edu.itbrains.furniture.models.Cart;
import az.edu.itbrains.furniture.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor

public class CartController {
    private final CartService cartService;
    @GetMapping("/cart")
    private String cart(Model model, Principal principal){
    if(principal==null){
        return "redirect:/login";
    }
    String username= principal.getName();
        List<Cart> cartItems=cartService.getCartItemsByUserName(username);
        double subtotal=cartService.calculateSubtotal(cartItems);
        model.addAttribute("cartItems",cartItems);
        model.addAttribute("cartTotal",subtotal);

        return "cart.html";
    }
    @PostMapping("/cart/add")
        public String addToCart(@RequestParam Long productId, Principal principal) {
            if (principal == null) return "redirect:/login";

            String username = principal.getName();
            cartService.addToCart(username, productId);
            return "redirect:/cart";
    }
    @PostMapping("/delete")
    private String delete(@RequestParam Long productId,Principal principal){

        String username=principal.getName();
        cartService.deleteItem(username,productId);
        return "redirect:/cart";
    }
    @PostMapping("/update")
    public String updateQuantity(@RequestParam Long productId,
                                 @RequestParam String action,
                                 Principal principal) {
        String username = principal.getName();

        if (action.equals("increase")) {
            cartService.increaseQuantity(username, productId);
        } else if (action.equals("decrease")) {
            cartService.decreaseQuantity(username, productId);
        }

        return "redirect:/cart";
    }

}
