package com.nahide.librarymanagement.controllers;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Publisher;
import com.nahide.librarymanagement.services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

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


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Publisher publisher = publisherService.getPublisherById(id);
        model.addAttribute("publisher",publisher);
        return "publisher/update-publisher";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @Valid Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            publisher.setId(id);
            return "publisher/update-publisher";
        }
        publisherService.savePublisher(publisher);
        model.addAttribute("publishers", publisher);
        return "redirect:/publishers";
    }
}
