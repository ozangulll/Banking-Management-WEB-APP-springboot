package com.sau.bankingmanagement.controllers;

import com.sau.bankingmanagement.models.Account;
import com.sau.bankingmanagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccountController {
private AccountRepository accountRepository;
    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @GetMapping("/accounts")
    public String listAccounts(Model model){
        List<Account> accounts=accountRepository.findAll();
        model.addAttribute("accounts",accounts);
        return "accounts-list";
    }
}
