package az.edu.itbrains.furniture.services;

import az.edu.itbrains.furniture.models.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCartItemsByUserName(String username);

    double calculateSubtotal(List<Cart> cartItems);


    void addToCart(String username, Long productId);

    void deleteItem(String username, Long productId);

    void increaseQuantity(String username, Long productId);

    void decreaseQuantity(String username, Long productId);
}
