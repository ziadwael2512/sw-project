package com.swproject.hello;

import java.util.List;

public interface CategoryService {
    Category add(Category category);
    List<Category> getAll();
    List<Category> getByCategoryName(String categoryName);
    List<Category> filterCategories(String category, Double minPrice, Double maxPrice);

}
