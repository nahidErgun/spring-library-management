package com.nahide.librarymanagement.controllers;

import com.nahide.librarymanagement.exception.RecordNotFoundException;
import com.nahide.librarymanagement.models.Borrower;
import com.nahide.librarymanagement.services.BorrowerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/borrowers")
public class BorrowerController {
    private final BorrowerService borrowerService;
    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }
    @RequestMapping
    public String getBorrowerList(Model model) {
        List<Borrower> borrowerList= borrowerService.selectAll();

        model.addAttribute("borrowers", borrowerList);

        return "borrower/list";
    }

    @RequestMapping("/add")
    public String createBorrower(Model model) {
        model.addAttribute("borrower", new Borrower());
        return "borrower/add";
    }

    @RequestMapping(path="/save", method = RequestMethod.POST)
    public String saveBorrower(Model model, Borrower borrower) {
        System.out.println("Incoming Book: " + borrower.toString());
        Borrower savedBorrower = borrowerService.saveBorrower(borrower);
        model.addAttribute("borrower", savedBorrower);
        return "borrower/borrower-after-save";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteBorrowerById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        borrowerService.deleteBorrowerById(id);
        return "redirect:/borrowers";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Borrower borrower = borrowerService.getBorrowerById(id);
        System.out.println("Borrower " + borrower);
        model.addAttribute("borrower",borrower);
        return "borrower/update-borrower";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid Borrower borrower, BindingResult result, Model model) {
        if (result.hasErrors()) {
            borrower.setId(id);
            return "borrower/update-borrower";
        }
        borrowerService.saveBorrower(borrower);
        model.addAttribute("borrowers", borrower);
        return "redirect:/borrowers";
    }
}
