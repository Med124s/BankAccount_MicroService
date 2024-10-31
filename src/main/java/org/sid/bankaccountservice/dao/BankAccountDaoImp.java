package org.sid.bankaccountservice.dao;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.model.BankAccount;
import org.sid.bankaccountservice.repository.BankAccountRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class BankAccountDaoImp implements IBankAccountDao {
    private final BankAccountRepository bankAccountRepository;

    public BankAccountDaoImp(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccount findBankAccountById(String id) {
        return bankAccountRepository.findById(id).
                orElseThrow(()->new RuntimeException(String.format("Bank account with id %s not found", id)));
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccount addBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccount updateBankAccount(String id, BankAccountRequestDTO bankAccount) {

        BankAccount bankAccount1 = bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Bank account with id %s not found", id)));
        if (bankAccount.getBalance()!=null) {
            bankAccount1.setBalance(bankAccount.getBalance());
        }
        if (bankAccount.getType()!=null) {
            bankAccount1.setType(bankAccount.getType());
        }
        if (bankAccount.getCurrency()!=null) {
            bankAccount1.setCurrency(bankAccount.getCurrency());
        }
            bankAccount1.setCreatedAt(new Date());
        return bankAccountRepository.save(bankAccount1);
    }

    @Override
    public void deleteBankAccount(String id) {
        BankAccount bankAccount1 = this.findBankAccountById(id);
        bankAccountRepository.delete(bankAccount1);
    }
}
