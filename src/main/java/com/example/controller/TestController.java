package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
    @GetMapping("/index")
    public String test(Model model){
        User user = new User("Anna","zoanna5442@gmail.com",true);

        model.addAttribute("hello","Hello Tymeleaf!");
        model.addAttribute("user",user);
        model.addAttribute("name",user.getUsername());
        model.addAttribute("email",user.getEmail());
        return "index";
    }
}
