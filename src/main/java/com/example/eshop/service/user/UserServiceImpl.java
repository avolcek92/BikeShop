package com.example.eshop.service.user;

import com.example.eshop.model.Product;
import com.example.eshop.model.User;
import com.example.eshop.repository.UserRepository;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);

    }

    @Override
    public User findById(long id) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Invalid user id: " + id));
        return user;
    }

}
