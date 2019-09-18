package com.nahide.librarymanagement.controllers;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Author;
import com.nahide.librarymanagement.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @RequestMapping
    public String getAuthorList(Model model) {
        List<Author> authorList= authorService.selectAll();

        model.addAttribute("authors", authorList);

        return "author/list";
    }

    @RequestMapping("/add")
    public String createAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }

    @RequestMapping(path="/save", method = RequestMethod.POST)
    public String saveAuthor(Model model, Author author) {
        System.out.println("Incoming Book: " + author.toString());
        com.nahide.librarymanagement.models.Author savedAuthor = authorService.saveAuthor(author);
        model.addAttribute("author", savedAuthor);
        return "author/author-after-save";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteAuthorById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Author author = authorService.getAuthorById(id);
        System.out.println("Author " + author);
        model.addAttribute("author",author);
        return "author/update-author";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            author.setId(id);
            return "author/update-author";
        }
        authorService.saveAuthor(author);
        model.addAttribute("authors", author);
        return "redirect:/authors";
    }
}
