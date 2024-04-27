package com.sau.bankingmanagement.controllers;


import com.sau.bankingmanagement.models.Account;
import com.sau.bankingmanagement.models.Customer;
import com.sau.bankingmanagement.repository.AccountRepository;
import com.sau.bankingmanagement.repository.CustomerRepository;
import groovy.lang.GString;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping ("/customers")
    public String listCustomers(Model model){
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customers-list";

    }
    //SAVE CUSTOMER
    //Update Customer
    //DeleteCustomer
    @GetMapping ("customers/add")
    public String addCustomerForm(Model model){
            Customer customer=new Customer();
            model.addAttribute("customer",customer);
            return "create-customer";
        }
    @PostMapping("customers/add")
    public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "create-customer";
        }
        if(customerRepository.existsById(customer.getId())){
            model.addAttribute("errorMessage","A customer with this ID already exists!");
        }
        customerRepository.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("customers/update/{id}")
    public String updateCustomerForm(@PathVariable("id") int id,Model model){
        Optional<Customer> customer=customerRepository.findById(id);
        model.addAttribute("customer",customer);
        return "update-customer";
    }
    @PostMapping("customers/update/{id}")
    public  String updateCustomer(@ModelAttribute("customer") @Valid Customer customer,BindingResult bindingResult){
      if(bindingResult.hasErrors()){
          return "update-customer";
      }
      customerRepository.save(customer);
      return "redirect:/customers";
    }
    @GetMapping("customers/delete/{id}")
    public String deleteCustomerForm(@PathVariable("id") int id, Model model){
        Optional<Customer> customer = customerRepository.findById(id);
        model.addAttribute("customer", customer);
        return "delete-screen-customer";
    }
    @PostMapping("customers/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        customerRepository.deleteById(id);
        return "redirect:/customers";
    }
    @GetMapping("/customers/search")
    public String searchName(@RequestParam(value = "query") String query, Model model) {
        List<Account> customers = customerRepository.searchName(query);
        model.addAttribute("customers", customers);
        return "customer-list";
    }





}
