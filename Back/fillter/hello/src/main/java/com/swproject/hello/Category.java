package com.swproject.hello;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORYS")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_name")
    private String categoryName;
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @OneToMany
    private List<Product> product;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
    

}