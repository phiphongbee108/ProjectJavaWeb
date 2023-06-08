package com.backend.controller.restAPI;

import com.backend.models.Account;
import com.backend.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/registration")
    public Boolean createAccount(@ModelAttribute Account account) {
        accountService.createOrUpdateAccount(account);
        return true;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccount() {
    List<Account> list = accountService.getAllAccount();
    return list;
    }

    @GetMapping("/getAccountById/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @GetMapping("/editAccount/{id}")
    public Account editAccount(@PathVariable Long id) {
        return accountService.editAccount(id);
    }

    @PutMapping("/updateAccount/{id}")
    public Boolean updateAccount(@PathVariable Long id, @ModelAttribute Account account) {
        Account accountOrigin = accountService.getAccount(id);
//        accountOrigin.setName(account.getName());
        accountOrigin.setPassWord(account.getPassword());
        accountOrigin.setUserName(account.getPassword());
        accountOrigin.setRole_user(account.getRole_user());
        accountService.createOrUpdateAccount(accountOrigin);
        return true;
    }

    @DeleteMapping("/deleteAccount/{id}")
    public Boolean deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return true;
    }
}
