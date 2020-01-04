package com.example.demo.repositories;

import com.example.demo.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankRepository extends JpaRepository<Bank, Long> {

    @Query("SELECT t FROM Bank t where t.clientID = :clientID")
    Bank findBankByClientID(@Param("clientID") Long clientID);
}
