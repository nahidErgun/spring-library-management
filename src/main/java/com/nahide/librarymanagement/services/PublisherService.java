package com.nahide.librarymanagement.services;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Publisher;
import com.nahide.librarymanagement.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    public List<Publisher> selectAll() {
        List<Publisher> publishers = (List<Publisher>) publisherRepository.findAll();

        if (publishers.size() > 0) {
            return publishers;
        } else {
            return new ArrayList<>();
        }
    }

    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deletePublisherById(Long id) throws RecordNotFoundException {
        Optional<Publisher> publisher = publisherRepository.findById(id);

        if (publisher.isPresent()) {
            publisherRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No publisher record exist for given id");
        }
    }
}
