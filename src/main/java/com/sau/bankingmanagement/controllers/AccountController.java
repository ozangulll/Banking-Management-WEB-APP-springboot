package com.sau.bankingmanagement.controllers;

import com.sau.bankingmanagement.models.Account;
import com.sau.bankingmanagement.repository.AccountRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AccountController {
private AccountRepository accountRepository;
    @GetMapping("/")
    public String showHomePage() {
        return "header";
    }
    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @GetMapping("/accounts")
    public String listAccounts(Model model){
        List<Account> accounts=accountRepository.findAll();
        model.addAttribute("accounts",accounts);
        return "accounts-list";
        //we use th:each for foreach loop in thymeleaf for instance th:each="account :${accounts}"
        //the second one ACCOUNTS aslında bizi burada eklediğimiz addattribute'a denk gelmiş oluyor.
    }
    @GetMapping("/accounts/add")
    public String AddAccountForm(Model model){
        Account account=new Account();
        model.addAttribute("account",account);
        return "create-account";
    }
    @PostMapping("/accounts/add")
    public String AddAccount(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create-account";
        }
    accountRepository.save(account);
    return "redirect:/accounts";
    }
    @GetMapping("/accounts/delete/{id}")
    public String DeleteAccountScreen(@PathVariable("id") int id, Model model){
        Optional<Account> account = accountRepository.findById(id);
        model.addAttribute("account", account);
        return "delete-screen";
    }
    @PostMapping("/accounts/delete/{id}")
    public String deleteAccount(@PathVariable("id") int id){
        accountRepository.deleteById(id);
        return "redirect:/accounts";
    }
    @GetMapping("/accounts/search")
    public String searchBranch(@RequestParam(value = "query") String query, Model model) {
        List<Account> accounts = accountRepository.searchBranch(query);
        model.addAttribute("accounts", accounts);
        return "accounts-list";
    }
    @GetMapping("accounts/update/{id}")
    public  String UpdateAccountForm( @PathVariable("id") int id, Model model){
        Optional<Account> account=accountRepository.findById(id);
        model.addAttribute("account",account);
        return "update-account";
    }
    @PostMapping("accounts/update/{id}")
    public  String UpdateAccount(@ModelAttribute("account")  @Valid Account account, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "update-account";
        }
accountRepository.save(account);
return "redirect:/accounts";

    }
}
