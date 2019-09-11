package com.nahide.librarymanagement.services;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Book;
import com.nahide.librarymanagement.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> selectAll() {
        List<Book> books = (List<Book>) bookRepository.findAll();

        if (books.size() > 0) {
            return books;
        } else {
            return new ArrayList<>();
        }
    }


    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


    public void deleteBookById(Long id) throws RecordNotFoundException
    {
        Optional<Book> book = bookRepository.findById(id);

        if(book.isPresent())
        {
            bookRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No book record exist for given id");
        }
    }

    public Book getBookById(Long id)
    {
        Optional<Book> book = bookRepository.findById(id);

        return book.get();
    }

}