package com.example.eshop.service.user;

import com.example.eshop.model.Product;
import com.example.eshop.model.User;
import com.example.eshop.repository.UserRepository;

import javax.annotation.Resource;
import java.util.List;

public interface UserService {

    List<User> findAll();

    void saveUser(User user);

    void deleteUser(User user);

    User findById(long id);


}
