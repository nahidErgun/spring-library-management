package com.nahide.librarymanagement.services;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Genre;
import com.nahide.librarymanagement.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

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


    public void deleteGenreById(Long id) throws RecordNotFoundException
    {
        Optional<Genre> genre = genreRepository.findById(id);

        if(genre.isPresent())
        {
            genreRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No genre record exist for given id");
        }
    }

}