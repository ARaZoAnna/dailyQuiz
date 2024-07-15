package com.example.controller;

import com.example.domain.Product;
import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    private List<Product> products = new ArrayList<>();



    @GetMapping("/index")
    public String test(Model model){
        User user = new User("Anna","zoanna5442@gmail.com",true,"1234");

        model.addAttribute("hello","Hello Tymeleaf!");
        model.addAttribute("user",user);
        model.addAttribute("name",user.getUsername());
        model.addAttribute("email",user.getEmail());

        Product product1 = new Product(1,"제품1",10000);
        Product product2 = new Product(2,"제품2",560000);
        products.add(product1);
        products.add(product2);
        model.addAttribute("products",products);
        return "index";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "form";
    }


    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") User user){
        System.out.println("유저의 이름은" + user.getUsername() + "입니다.");
        System.out.println("유저의 이메일은" + user.getEmail() + "입니다.");
        System.out.println("유저의 비밀번호는" + user.getPassword() + "입니다.");
        return "redirect:/form";
    }

}
