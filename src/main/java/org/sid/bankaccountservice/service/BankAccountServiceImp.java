package org.sid.bankaccountservice.service;

import jakarta.transaction.Transactional;
import org.sid.bankaccountservice.dao.IBankAccountDao;
import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.mapper.AccountMapper;
import org.sid.bankaccountservice.model.BankAccount;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BankAccountServiceImp implements IBankAccountService {
    private final IBankAccountDao bankAccountDTO;
    private final AccountMapper accountMapper;
    public BankAccountServiceImp(IBankAccountDao bankAccountDTO, AccountMapper accountMapper) {
        this.bankAccountDTO = bankAccountDTO;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccount findBankAccountById(String id) {
        return bankAccountDTO.findBankAccountById(id);
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountDTO.getAllBankAccounts();
    }

    @Override
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = accountMapper.fromBankAccountRequestDto(bankAccountRequestDTO);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        BankAccount savingBankAccount = bankAccountDTO.addBankAccount(bankAccount);
        return accountMapper.fromBankAccount(savingBankAccount);
    }

    @Override
    public BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccount) {
        System.out.println(bankAccount.getBalance());
        BankAccount savingBankAccount = bankAccountDTO.updateBankAccount(id, bankAccount);
        return accountMapper.fromBankAccount(savingBankAccount);
    }

    @Override
    public void deleteBankAccount(String id) {
        bankAccountDTO.deleteBankAccount(id);
    }
}
