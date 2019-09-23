package com.nahide.librarymanagement.controllers;

import com.nahide.librarymanagement.models.Genre;
import com.nahide.librarymanagement.repositories.GenreRepository;
import com.nahide.librarymanagement.services.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;
    private final GenreRepository genreRepository;

    public GenreController(GenreService genreService, GenreRepository genreRepository) {
        this.genreService = genreService;
        this.genreRepository = genreRepository;
    }

    @RequestMapping
    public String getGenreList(Model model) {
        List<Genre> genreList= genreService.selectAll();

        model.addAttribute("genres", genreList);

        return "genre/list";
    }

    @RequestMapping("/add")
    public String createGenre(Model model) {
        model.addAttribute("genre", new Genre());
        return "genre/add";
    }

    @RequestMapping(path="/save", method = RequestMethod.POST)
    public String saveGenre(Model model, Genre genre, RedirectAttributes redirectAttributes) {
        System.out.println("Incoming Book: " + genre.toString());
        Genre savedGenre = genreService.saveGenre(genre);
        model.addAttribute("genre", savedGenre);
        redirectAttributes.addFlashAttribute("message", "Tür eklendi.");
        return "redirect:/genres";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteGenreById(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes)
    {
        genreService.deleteGenreById(id);
        redirectAttributes.addFlashAttribute("message", id +" id'li tür silindi.");
        return "redirect:/genres";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Genre genre = genreService.getGenreById(id);
        System.out.println("Genre " + genre);
        model.addAttribute("genre",genre);
        return "genre/update-genre";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid Genre genre, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            genre.setId(id);
            return "genre/update-genre";
        }
        System.out.println("Genre12 " + genre);
        genreService.saveGenre(genre);
        model.addAttribute("genres", genre);
        redirectAttributes.addFlashAttribute("message", id +" id'li tür güncellendi.");
        return "redirect:/genres";
    }
}
