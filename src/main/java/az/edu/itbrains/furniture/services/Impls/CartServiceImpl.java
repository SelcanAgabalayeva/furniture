package az.edu.itbrains.furniture.services.Impls;

import az.edu.itbrains.furniture.models.Cart;
import az.edu.itbrains.furniture.models.Product;
import az.edu.itbrains.furniture.models.User;
import az.edu.itbrains.furniture.repositories.CartRepository;
import az.edu.itbrains.furniture.repositories.ProductRepository;
import az.edu.itbrains.furniture.repositories.UserRepository;
import az.edu.itbrains.furniture.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Cart> getCartItemsByUserName(String username) {
        return cartRepository.findByUserUsername(username);
    }

    @Override
    public double calculateSubtotal(List<Cart> cartItems) {
        return cartItems.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    @Override
    public void addToCart(String username, Long productId) {
        User user = userRepository.findByUsername(username);
        Product product = productRepository.findById(productId).orElseThrow();

        Cart existing = cartRepository.findByUserAndProduct(user, product);
        if (existing != null) {
            System.out.println("Artırıldı");
            existing.setQuantity(existing.getQuantity() + 1);
            cartRepository.save(existing);
        } else {
            System.out.println("Yeni əlavə edildi");
            Cart newCart = new Cart();
            newCart.setUser(user);
            newCart.setProduct(product);
            newCart.setQuantity(1);
            newCart.setName(product.getName());
            newCart.setPhotoUrl(product.getPhotoUrl());
            newCart.setPrice(product.getPrice());
            cartRepository.save(newCart);
        }
    }


    @Override
    public void deleteItem(String username, Long productId) {
        Cart item=cartRepository.findByUserUsernameAndProductId(username,productId);
        if (item!=null){
            cartRepository.delete(item);
        }
    }

    @Override
    public void increaseQuantity(String username, Long productId) {
        Cart item = cartRepository.findByUserUsernameAndProductId(username, productId);
        if (item != null) {
            item.setQuantity(item.getQuantity() + 1);
            cartRepository.save(item);
        }
    }

    @Override
    public void decreaseQuantity(String username, Long productId) {
        Cart item = cartRepository.findByUserUsernameAndProductId(username, productId);
        if (item != null) {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                cartRepository.save(item);
            } else {
                cartRepository.delete(item);
            }

        }
    }






}
