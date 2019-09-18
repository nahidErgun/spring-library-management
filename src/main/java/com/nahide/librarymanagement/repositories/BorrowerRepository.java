package com.nahide.librarymanagement.repositories;

import com.nahide.librarymanagement.models.Borrower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends CrudRepository<Borrower, Long> {

}
