package com.example.controller;

import com.example.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class BookController {
    List<Book> books = new ArrayList<Book>();

    @GetMapping("/addBook")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book) {
        books.add(book);
        return "redirect:books";
    }
    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("books", books);
        return "books";
    }

}
