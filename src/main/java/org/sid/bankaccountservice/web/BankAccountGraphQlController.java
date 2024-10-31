package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.model.BankAccount;
import org.sid.bankaccountservice.model.Customer;
import org.sid.bankaccountservice.repository.BankAccountRepository;
import org.sid.bankaccountservice.repository.CustomerRepository;
import org.sid.bankaccountservice.service.IBankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {
    private final IBankAccountService bankAccountService;
    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;
    public BankAccountGraphQlController(IBankAccountService bankAccountService,
                                        BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {

        this.bankAccountService = bankAccountService;
        this.bankAccountRepository = bankAccountRepository;
        this.customerRepository = customerRepository;
    }
    @QueryMapping
    public List<BankAccount>accountsList(){
        return bankAccountService.getAllBankAccounts();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountService.findBankAccountById(id);
    }
    @MutationMapping
    public BankAccountResponseDTO addBankAccount(@Argument BankAccountRequestDTO bankAccount){
        return bankAccountService.addBankAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateBankAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
        return bankAccountService.updateBankAccount(id,bankAccount);
    }
    @MutationMapping
    public void deleteBankAccount(@Argument String id){
         bankAccountService.deleteBankAccount(id);
    }
    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
}
