package com.nahide.librarymanagement.services;

import com.nahide.librarymanagement.models.Genre;
import com.nahide.librarymanagement.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> selectAll() {
        List<Genre> genres = (List<Genre>) genreRepository.findAll();

        if (genres.size() > 0) {
            return genres;
        } else {
            return new ArrayList<>();
        }
    }

    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }


    public void deleteGenreById(Long id)
    {
            genreRepository.deleteById(id);
    }

    public Genre getGenreById(Long id)
    {
        Optional<Genre> genre = genreRepository.findById(id);

            return genre.get();
    }

}
