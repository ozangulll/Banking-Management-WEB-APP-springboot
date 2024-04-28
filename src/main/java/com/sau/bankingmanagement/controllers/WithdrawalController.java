package com.sau.bankingmanagement.controllers;

import com.sau.bankingmanagement.models.Account;
import com.sau.bankingmanagement.models.Customer;
import com.sau.bankingmanagement.models.Withdrawal;
import com.sau.bankingmanagement.repository.WithdrawalRepository;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

public class WithdrawalController {
    WithdrawalRepository withdrawalRepository;
    public WithdrawalController(WithdrawalRepository _withdrawalRepository){
        withdrawalRepository=_withdrawalRepository;
    }
    @GetMapping("withdrawals")
    public String getAllWithdrawals(Model model){
        List<Withdrawal> withdrawals=withdrawalRepository.findAll();
        model.addAttribute("withdrawals",withdrawals);
        return "withdrawal-list";
    }
    @GetMapping("withdrawals/add")
    public String AddFormWithdrawal(Model model){
        Withdrawal withdrawal=new Withdrawal();
        model.addAttribute("withdrawal",withdrawal);
        return "create-withdrawal";

    }
    @PostMapping("withdrawals/add")
    public String AddWithdrawal(@Valid @ModelAttribute("withdrawal") Withdrawal withdrawal, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "create-withdrawal";
        }

        withdrawalRepository.save(withdrawal);
        return "redirect:/withdrawals";
    }
    @GetMapping("withdrawals/update/{id}")
    public String updateWithdrawalForm(@PathVariable("id") int id,Model model ){
        Optional<Withdrawal> withdrawal= withdrawalRepository.findById(id);
        model.addAttribute("withdrawal",withdrawal);
        return "update-withdrawal";
    }
    @PostMapping("withdrawals/update/{id}")
    public  String updateWithdrawal(@ModelAttribute("withdrawal") @Valid Withdrawal withdrawal, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "update-withdrawal";
        }
        withdrawalRepository.save(withdrawal);
        return "redirect:/withdrawals";
    }
    @GetMapping("withdrawals/delete/{id}")
    public String deleteWithdrawalForm(@PathVariable("id") int id, Model model){
        Optional<Withdrawal> withdrawal = withdrawalRepository.findById(id);
        model.addAttribute("withdrawal", withdrawal);
        return "delete-screen-withdrawal";
    }
    @PostMapping("withdrawals/delete/{id}")
    public String deleteWithdrawal(@PathVariable("id") int id){
        withdrawalRepository.deleteById(id);
        return "redirect:/withdrawals";
    }
}
