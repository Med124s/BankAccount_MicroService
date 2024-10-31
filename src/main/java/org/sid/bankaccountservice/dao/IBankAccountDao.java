package org.sid.bankaccountservice.dao;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.model.BankAccount;

import java.util.List;

public interface IBankAccountDao {
    BankAccount findBankAccountById(String id);
    List<BankAccount> getAllBankAccounts();
    BankAccount addBankAccount(BankAccount bankAccount);
    BankAccount updateBankAccount(String id, BankAccountRequestDTO bankAccount);
    void deleteBankAccount(String id);
}
