package org.sid.bankaccountservice;

import org.sid.bankaccountservice.model.AccountType;
import org.sid.bankaccountservice.model.BankAccount;
import org.sid.bankaccountservice.model.Customer;
import org.sid.bankaccountservice.repository.BankAccountRepository;
import org.sid.bankaccountservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository accountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Mohamed","Hasnae","Aziz","Hanae").forEach(name -> {
            Customer customer = new Customer();
            customer.setName(name);
            customerRepository.save(customer);
            for(int i=0;i<10;i++){
                BankAccount account = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(10000 + Math.random()*90000)
                        .createdAt(new Date())
                        .type(Math.random() >= 0.5? AccountType.SAVINGS_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                        .currency(Math.random() >= 0.5? "EURO":"MAD")
                        .customer(customer)
                        .build();
                accountRepository.save(account);
            }
            });

        };
    }

}
