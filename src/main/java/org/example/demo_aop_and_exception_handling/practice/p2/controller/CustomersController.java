package org.example.demo_aop_and_exception_handling.practice.p2.controller;

import org.example.demo_aop_and_exception_handling.practice.p2.exception.DuplicateEmailException;
import org.example.demo_aop_and_exception_handling.practice.p2.model.Customers;
import org.example.demo_aop_and_exception_handling.practice.p2.service.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/practice/p2/customers")
public class CustomersController {
    @Autowired
    private ICustomersService customersService;

    @GetMapping("")
    public String index(Model model) {
        List<Customers> customersList = customersService.findAll();
        model.addAttribute("customers", customersList);
        return "practice/p2/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customers());
        return "practice/p2/create";
    }

    @PostMapping("/save")
    public String save(Customers customer) throws DuplicateEmailException {
        customersService.save(customer);
        return "redirect:/practice/p2/customers";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customersService.findById(id));
        return "practice/p2/update";
    }

    @PostMapping("/update")
    public String update(Customers customer) throws DuplicateEmailException {
        customersService.save(customer);
        return "redirect:/practice/p2/customers";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customersService.findById(id));
        return "practice/p2/delete";
    }

    @PostMapping("/delete")
    public String delete(Customers customer, RedirectAttributes redirectAttributes) {
        customersService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/practice/p2/customers";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customersService.findById(id));
        return "practice/p2/view";
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/practice/p2/inputs-not-acceptable");
    }
}