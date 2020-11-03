package com.example.eshop.service.product;

import com.example.eshop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    void saveProduct(Product product);

    void deleteProduct(Product product);

    Product findById(long id);


}
