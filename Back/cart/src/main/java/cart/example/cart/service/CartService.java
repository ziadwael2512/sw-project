package cart.example.cart.service;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cart.example.cart.Model.Cart;
import cart.example.cart.Model.Product;
import cart.example.cart.dto.AddToCartDto;
import cart.example.cart.repository.CartRepository;
@Service
public class CartService {
    @Autowired
    ProductService productService;

    @Autowired
    CartRepository cartRepository;

    public void addToCart(AddToCartDto addToCartDto) {

        
        Product product = productService.findById(addToCartDto.getProductId());

        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date(0));


        // save the cart
        cartRepository.save(cart);

    }
}
