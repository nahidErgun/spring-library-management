package com.nahide.librarymanagement.repositories;

import com.nahide.librarymanagement.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
