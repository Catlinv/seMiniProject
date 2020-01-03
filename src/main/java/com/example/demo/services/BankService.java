package com.example.demo.services;

import com.example.demo.domain.Bank;
import org.springframework.stereotype.Service;

@Service
public interface BankService {

    Bank findBankById(Long id);
    Bank findBankByClientId(Long id);

    boolean completePurchase(Long id, float val);

}
