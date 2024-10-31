package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.model.BankAccount;
import org.sid.bankaccountservice.service.IBankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankAccountController {
    private final IBankAccountService bankAccountService;
    public BankAccountController(IBankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> getBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }
    @GetMapping("/bankAccount/{id}")
    public BankAccount getBankAccount(@PathVariable(name = "id") String id) {
        return bankAccountService.findBankAccountById(id);
    }
    @PostMapping("/bankAccount")
    public BankAccountResponseDTO saveBankAccount(@RequestBody() BankAccountRequestDTO bankAccountRequestDTO) {
        return bankAccountService.addBankAccount(bankAccountRequestDTO);
    }
    @PutMapping("/bankAccount/{id}")
    public BankAccountResponseDTO updateBankAccount(@RequestBody() BankAccountRequestDTO bankAccount,@PathVariable String id) {
        return bankAccountService.updateBankAccount(id,bankAccount);
    }
    @DeleteMapping("/bankAccount/{id}")
    public void deleteBankAccount(@PathVariable String id) {
         bankAccountService.deleteBankAccount(id);
    }


}
