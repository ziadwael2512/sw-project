package com.swproject.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public Page<Product> getAllProducts(int pageNumber, String searchKey) {
        Pageable pageable = PageRequest.of(pageNumber, 12);

        if (searchKey == null || searchKey.isEmpty()) {

            return productRepository.findAll(pageable);

        } else {

            return productRepository.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
                searchKey, searchKey, pageable
            );
            
        }
    }
    
    public Product getProductDetailsById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
