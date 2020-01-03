package com.example.demo.services;

import com.example.demo.controllers.Bitstream;
import com.example.demo.domain.Bank;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.BankRepository;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank findBankById(Long id) {

        return bankRepository.findById(id).get();
    }

    @Override
    public Bank findBankByClientId(Long id) {
        Bank newB = new Bank();
        newB.setId(null);
        newB.setClientID(id);
        newB.setClientKey(null);
        newB.setSum(0.0f);
        Example<Bank> example = Example.of(newB);
        return bankRepository.findOne(example).get();
    }


    @Override
    public boolean completePurchase(Long id, float val) {

        Bank aux = findBankByClientId(id);
        if (aux == null || aux.getSum() < val) return false;
        aux.setSum(aux.getSum() - val);
        bankRepository.save(aux);
        return true;
    }
}
