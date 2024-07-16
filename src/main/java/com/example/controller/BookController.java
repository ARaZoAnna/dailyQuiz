package com.example.controller;

import com.example.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/editBook/{id}")
    public String showEditBookForm(@PathVariable int id, Model model) {
        Book book = books.stream()
                .filter(p->p.getId()== id)
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Book not found"));
        model.addAttribute("book",book);
        return "editBook";
    }
    @PostMapping("/editBook")
    public String editBook(@ModelAttribute("book") Book book) {

        for(int i =0; i<books.size(); i++) {
            if(books.get(i).getId() == book.getId()) {
                books.get(i).setTitle(book.getTitle());
                books.get(i).setAuthor(book.getAuthor());
                books.get(i).setYear(book.getYear());
                break;
            }
        }

//                Book oldbook = books.stream()
//                .filter(p->p.getId()==book.getId())
//                .findFirst()
//                .orElseThrow(()->new IllegalArgumentException("Book not found"));
//        oldbook.setTitle(book.getTitle());
//        oldbook.setAuthor(book.getAuthor());
//        oldbook.setYear(book.getYear());
        return "redirect:/books";
    }
    @PostMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id) {
//        for(Book book: books) {
//            if(book.getId() == id) {
//                books.remove(book);
//            }
//        }
        books.removeIf(p->p.getId()== id);
        return "redirect:/books";
    }


}
