package com.example.eshop.repository;

import com.example.eshop.model.Product;
import com.example.eshop.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

}
