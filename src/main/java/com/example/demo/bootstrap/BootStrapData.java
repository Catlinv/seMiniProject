package com.example.demo.bootstrap;

import com.example.demo.controllers.Bitstream;
import com.example.demo.domain.Bank;
import com.example.demo.repositories.BankRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final BankRepository bankRepository;

    public BootStrapData(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Movie Data");

        Bank c1 = new Bank();
        c1.setClientID(1L);
        c1.setClientKey("Client1");
        c1.setSum(123.11f);
        bankRepository.save(c1);

        Bank c2 = new Bank();
        c2.setClientID(2L);
        c2.setClientKey("Client2");
        c2.setSum(1230.11f);
        bankRepository.save(c2);

        Bank c3 = new Bank();
        c3.setClientID(3L);
        c3.setClientKey("Client3");
        c3.setSum(12300.11f);
        bankRepository.save(c3);


        System.out.println("Accounts Added: " + bankRepository.count());

    }


}
