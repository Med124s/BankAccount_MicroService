package org.sid.bankaccountservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Double balance;
    private String currency;
    @ManyToOne
    private Customer customer;
}
