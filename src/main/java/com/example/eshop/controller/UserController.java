package com.example.eshop.controller;

import com.example.eshop.model.Product;
import com.example.eshop.model.User;
import com.example.eshop.service.product.ProductService;
import com.example.eshop.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class UserController {


    @Resource
    private UserService userService;


    @GetMapping("/users")
    public String showUsers(Model model) {
        pushProductListToThymeleaf(model);
        return "user_list";
    }


    @GetMapping("/addUser")
    public String showRegistrationForm(User user) {
        return "registration";
    }

    @PostMapping("/users")
    public String addUser(User user, Model model) {
        userService.saveUser(user);
        pushProductListToThymeleaf(model);
        return "redirect:/users";
    }

    @GetMapping("/removeUser/{id}")
    public String removeUser(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id);
        userService.deleteUser(user);
        pushProductListToThymeleaf(model);
        return "redirect:/users";

    }

    @GetMapping("/makeAdmin/{id}")
    public String changeAdminRights(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id);
        if (user.isAdmin()) {
            user.setAdmin(false);
        } else {
            user.setAdmin(true);
        }
        userService.saveUser(user);
        pushProductListToThymeleaf(model);
        return "redirect:/users";

    }


    private void pushProductListToThymeleaf(Model model) {
        model.addAttribute("users", userService.findAll());
    }


}

