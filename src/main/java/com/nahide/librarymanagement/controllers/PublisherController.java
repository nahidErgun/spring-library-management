package com.nahide.librarymanagement.controllers;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Publisher;
import com.nahide.librarymanagement.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    PublisherService publisherService;

    @RequestMapping
    public String getPublisherList(Model model) {
        List<Publisher> publisherList= publisherService.selectAll();

        model.addAttribute("publishers", publisherList);

        return "publisher/list";
    }

    @RequestMapping("/add")
    public String createPublisher(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/add";
    }


    @RequestMapping(path="/save", method = RequestMethod.POST)
    public String savePublisher(Model model, Publisher publisher) {
        System.out.println("Incoming Publisher : " + publisher.toString());
        Publisher savedPublisher = publisherService.savePublisher(publisher);
        model.addAttribute("publisher", savedPublisher);
        return "publisher/publishers-after-save";
    }


    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        publisherService.deletePublisherById(id);
        return "redirect:/publishers";
    }
}
