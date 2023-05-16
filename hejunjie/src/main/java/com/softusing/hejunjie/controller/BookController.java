package com.softusing.hejunjie.controller;

import com.softusing.hejunjie.entity.Book;
import com.softusing.hejunjie.server.BookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookServer bookServer;


    @GetMapping("/books-list") //整个书名列表
    public String list(Model model) {
        List<Book> bookList = bookServer.findAll();
        model.addAttribute("bookList", bookList);
        return "books";
    }


    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookServer.findOne(id);
        if (book == null) {
            book = new Book();
        }
        model.addAttribute("book", book);
        return "book";
    }


    /**
     * 跳转input提交页面
     *
     * @return
     */
    @GetMapping("/books/input")
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    /**
     * 跳转到更新页面input
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookServer.findOne(id);
        model.addAttribute("book", book);
        return "input";

    }

    /**
     * 提交一个书单信息
     *
     * @param book
     * @return
     */

    @PostMapping("/books")
    public String post(Book book) {
        bookServer.save(book);
        return "redirect:/books-list";
    }

    @PostMapping("/books/")
    public String post(Book book, final RedirectAttributes attributes) {
        Book book1 = bookServer.save(book);
        if (book1 != null) {
            attributes.addFlashAttribute("message", "<" + book1.getName() + ">信息提交成功");
        }
        return "redirect:books-list";
    }


}
