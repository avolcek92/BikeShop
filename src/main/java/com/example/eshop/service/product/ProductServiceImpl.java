package com.example.eshop.service.product;

import com.example.eshop.editor.ProductListEditor;
import com.example.eshop.model.Product;
import com.example.eshop.repository.ProductRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ProductServiceImpl implements ProductService {


    @Resource
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return new ProductListEditor().editList(productRepository.findAll());
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(long id) {
        Product product = productRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Invalid user id: " + id));
        return product;

    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);

    }


}



