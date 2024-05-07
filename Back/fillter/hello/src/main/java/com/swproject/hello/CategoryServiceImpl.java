package com.swproject.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category add(Category category) {
        if(categoryRepository.findByCategoryName(category.getCategoryName()) != null) {
            return null;
        }

        return categoryRepository.save(category);
    }

    public List<Category> filterProducts(String category, Double minPrice, Double maxPrice) {
        return categoryRepository.filterProducts(category, minPrice, maxPrice);
    }
}
