package com.example.eshop.repository;

import com.example.eshop.model.Product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
}
