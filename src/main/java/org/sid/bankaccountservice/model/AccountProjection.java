package org.sid.bankaccountservice.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class,name = "p1")
public interface AccountProjection {
    public String getId();
    public String getType();
    public Double getBalance();
}
