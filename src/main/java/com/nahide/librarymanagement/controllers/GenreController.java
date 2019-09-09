package com.nahide.librarymanagement.controllers;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Genre;
import com.nahide.librarymanagement.repositories.GenreRepository;
import com.nahide.librarymanagement.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    GenreService genreService;
    GenreRepository genreRepository;

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
    public String saveGenre(Model model, Genre genre) {
        System.out.println("Incoming Book: " + genre.toString());
        Genre savedGenre = genreService.saveGenre(genre);
        model.addAttribute("genre", savedGenre);
        return "genre/genre-after-save";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteGenreById(Model model, @PathVariable("id") Long id)
    {
        genreService.deleteGenreById(id);
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
    public String updateUser(@PathVariable("id") Long id, @Valid Genre genre, BindingResult result, Model model) {
        if (result.hasErrors()) {
            genre.setId(id);
            return "genre/update-genre";
        }
        System.out.println("Genre12 " + genre);
        genreService.saveGenre(genre);
        model.addAttribute("genres", genre);
        return "redirect:/genres";
    }
}
