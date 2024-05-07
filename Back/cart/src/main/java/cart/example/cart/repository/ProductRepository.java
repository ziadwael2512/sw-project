package cart.example.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cart.example.cart.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
