package cart.example.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cart.example.cart.Model.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
    
}
