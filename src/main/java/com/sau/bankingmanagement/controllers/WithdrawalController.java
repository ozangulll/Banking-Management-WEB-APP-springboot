package com.sau.bankingmanagement.controllers;

import com.sau.bankingmanagement.models.Account;
import com.sau.bankingmanagement.models.Customer;
import com.sau.bankingmanagement.models.Withdrawal;
import com.sau.bankingmanagement.repository.AccountRepository;
import com.sau.bankingmanagement.repository.CustomerRepository;
import com.sau.bankingmanagement.repository.WithdrawalRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class WithdrawalController {

    //UpdateWithdrawal


    WithdrawalRepository withdrawalRepository;
    AccountRepository accountRepository;
    CustomerRepository customerRepository;
    public WithdrawalController(WithdrawalRepository withdrawalRepository,AccountRepository accountRepository,CustomerRepository customerRepository){
        this.accountRepository=accountRepository;
        this.customerRepository=customerRepository;
        this.withdrawalRepository=withdrawalRepository;
    }
    //DisplayALLWithdrawals
    @GetMapping("withdrawals")
    public String getAllWithdrawals(Model model){
        List<Withdrawal> withdrawals=withdrawalRepository.findAll();
        model.addAttribute("withdrawals",withdrawals);
        return "withdrawal-list";
    }
    @GetMapping("withdrawals/customer/{customerid}")
    public String getWithdrawalsForCustomerId(@PathVariable("customerid") int customerId, Model model) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            List<Withdrawal> withdrawals = withdrawalRepository.findByCustomer(customer);
            model.addAttribute("withdrawals", withdrawals);
            return "withdrawal-list"; // Assuming there's a view named "withdrawal-list" to display withdrawals
        } else {
            return "customer-not-found"; // Example: return a view indicating customer not found
        }
    }
    @GetMapping("withdrawals/account/{accountId}")
    public String getWithdrawalsForAccountId(@PathVariable("accountId") int accountId, Model model) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            List<Withdrawal> withdrawals = withdrawalRepository.findByAccount(account);
            model.addAttribute("withdrawals", withdrawals);
            return "withdrawal-list"; // Assuming there's a view named "withdrawal-list" to display withdrawals
        } else {
            return "account-not-found"; // Example: return a view indicating account not found
        }
    }
    @GetMapping("withdrawals/add")
    public String AddFormWithdrawal(Model model){
        List<Account> accounts=accountRepository.findAll();
        List<Customer> customers=customerRepository.findAll();
        Withdrawal withdrawal=new Withdrawal();
        model.addAttribute("withdrawal",withdrawal);
        model.addAttribute("customers",customers);
        model.addAttribute("accounts",accounts);
        return "create-withdrawal";

    }

    @PostMapping("withdrawals/add")
    public String addWithdrawal(@Valid @ModelAttribute("withdrawal") Withdrawal withdrawal, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Hata varsa, hata mesajlarını göster ve aynı formu tekrar göster
            return "create-withdrawal";
        }

        withdrawalRepository.save(withdrawal);
        return "redirect:/withdrawals"; // Doğru şekilde yönlendirme yapılıyor
    }


    @GetMapping("/withdrawals/update/{id}")
    public String updateWithdrawalForm(@PathVariable("id") int id, Model model) {
        Optional<Withdrawal> optionalWithdrawal = withdrawalRepository.findById(id);
        if (optionalWithdrawal.isPresent()) {
            List<Account> accounts=accountRepository.findAll();
            List<Customer> customers=customerRepository.findAll();
            Withdrawal withdrawal = optionalWithdrawal.get();
            model.addAttribute("withdrawal", withdrawal);
            model.addAttribute("accounts", accounts);
            model.addAttribute("customers",customers);

            return "update-withdrawal";
        } else {
            return "redirect:/withdrawals";
        }
    }

    @PostMapping("/withdrawals/update/{id}")
    public String updateWithdrawal(@PathVariable("id") int id, @ModelAttribute("withdrawal") @Valid Withdrawal withdrawal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update-withdrawal";
        }

        Optional<Withdrawal> optionalWithdrawal = withdrawalRepository.findById(id);
        if (optionalWithdrawal.isPresent()) {
            Withdrawal existingWithdrawal = optionalWithdrawal.get();
            existingWithdrawal.setAccount(withdrawal.getAccount());
            existingWithdrawal.setCustomer(withdrawal.getCustomer());
            existingWithdrawal.setAmount(withdrawal.getAmount());
            existingWithdrawal.setUpdatedDate(LocalDateTime.now()); // Set the updatedDate
            withdrawalRepository.save(existingWithdrawal);
            return "redirect:/withdrawals";
        } else {
            // handle if withdrawal with given id does not exist
            return "redirect:/withdrawals";
        }
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
