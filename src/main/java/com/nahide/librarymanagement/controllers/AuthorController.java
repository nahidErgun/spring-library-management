package com.nahide.librarymanagement.controllers;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Author;
import com.nahide.librarymanagement.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String saveAuthor(Model model, Author author, RedirectAttributes redirectAttributes) {
        Author savedAuthor = authorService.saveAuthor(author);
        model.addAttribute("author", savedAuthor);
        redirectAttributes.addFlashAttribute("message", "Yazar eklendi.");
        return "redirect:/authors";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteAuthorById(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes) throws RecordNotFoundException {
        authorService.deleteAuthorById(id);
        redirectAttributes.addFlashAttribute("message", id + " id'li yazar silindi.");
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author",author);
        return "author/update-author";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid Author author, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        authorService.saveAuthor(author);
        model.addAttribute("authors", author);
        redirectAttributes.addFlashAttribute("message", id + " id'li yazar güncellendi.");
        return "redirect:/authors";
    }
}
