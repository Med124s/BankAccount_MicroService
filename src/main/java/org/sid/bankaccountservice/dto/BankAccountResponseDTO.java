package org.sid.bankaccountservice.dto;
import lombok.*;
import org.sid.bankaccountservice.model.AccountType;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private AccountType type;
    private Double balance;
    private String currency;
}
