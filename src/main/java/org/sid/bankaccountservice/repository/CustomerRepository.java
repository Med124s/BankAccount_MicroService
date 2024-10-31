package org.sid.bankaccountservice.repository;

import org.sid.bankaccountservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
