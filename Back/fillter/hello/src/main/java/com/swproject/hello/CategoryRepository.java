package com.swproject.hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAll();
    List<Category> findByCategoryAndPriceRange(String category, Double minPrice, Double maxPrice);
    List<Category> filterProducts(String category, Double minPrice, Double maxPrice);
    Category save(Category category);
    List<Category> findByCategoryName(String categoryName);
}

