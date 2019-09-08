package com.nahide.librarymanagement.controllers;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Book;
import com.nahide.librarymanagement.repositories.BookRepository;
import com.nahide.librarymanagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    BookRepository bookRepository;

    @RequestMapping
    public String getBookList(Model model) {
        List<Book> bookList = bookService.selectAll();

        model.addAttribute("books", bookList);

        return "book/list";
    }

    @RequestMapping("/add")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @RequestMapping("/edit/{id}")
    public String editBook(Model model, Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("book", book);
        return "edit-book";
    }

    @RequestMapping("/update/{id}")
    public String updateBook(Model model, Book book) {
        // save updated book and return the book
        return "update-book";
    }

    @RequestMapping(path="/save", method = RequestMethod.POST)
    public String saveBook(Model model, Book book) {
        System.out.println("Incoming Book: " + book.toString());
        Book savedBook = bookService.saveBook(book);
        model.addAttribute("book", savedBook);
        return "book/after-save";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteBookById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }


}