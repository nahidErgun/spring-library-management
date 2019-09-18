package com.nahide.librarymanagement.services;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Borrower;
import com.nahide.librarymanagement.repositories.BorrowerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowerService {

    private final BorrowerRepository borrowerRepository;

    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public List<Borrower> selectAll() {
        List<Borrower> borrower = (List<Borrower>) borrowerRepository.findAll();

        if (borrower.size() > 0) {
            return borrower;
        } else {
            return new ArrayList<>();
        }
    }

    public Borrower saveBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }


    public void deleteBorrowerById(Long id) throws RecordNotFoundException
    {
        Optional<Borrower> borrower = borrowerRepository.findById(id);

        if(borrower.isPresent())
        {
            borrowerRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No borrower record exist for given id");
        }
    }

    public Borrower getBorrowerById(Long id)
    {
        Optional<Borrower>borrower = borrowerRepository.findById(id);

        return borrower.get();
    }
}
