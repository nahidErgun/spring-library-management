package com.nahide.librarymanagement.controllers;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Genre;
import com.nahide.librarymanagement.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    GenreService genreService;

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
            throws RecordNotFoundException
    {
        genreService.deleteGenreById(id);
        return "redirect:/genres";
    }

}
