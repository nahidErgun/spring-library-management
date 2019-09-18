package com.nahide.librarymanagement.services;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Author;
import com.nahide.librarymanagement.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> selectAll() {
        List<Author> authors = (List<Author>) authorRepository.findAll();

        if (authors.size() > 0) {
            return authors;
        } else {
            return new ArrayList<>();
        }
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }


    public void deleteAuthorById(Long id) throws RecordNotFoundException
    {
        Optional<Author> author = authorRepository.findById(id);

        if(author.isPresent())
        {
            authorRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No author record exist for given id");
        }
    }

    public Author getAuthorById(Long id)
    {
        Optional<Author> author = authorRepository.findById(id);

        return author.get();
    }
}
