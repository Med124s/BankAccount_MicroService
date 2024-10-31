package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.model.BankAccount;

import java.util.List;

public interface IBankAccountService {
    BankAccount findBankAccountById(String id);
    List<BankAccount> getAllBankAccounts();
    BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccount);
    BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccount);
    void deleteBankAccount(String id);
}
