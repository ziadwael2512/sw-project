package com.swproject.hello;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
   
   Page<Product> findAll(Pageable pageable);

   Page<Product> findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
      String key1, String key2, Pageable pageable
   );
}
