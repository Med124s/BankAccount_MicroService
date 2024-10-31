package org.sid.bankaccountservice.dto;
import lombok.*;
import org.sid.bankaccountservice.model.AccountType;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountRequestDTO {
    private AccountType type;
    private Double balance;
    private String currency;
}
