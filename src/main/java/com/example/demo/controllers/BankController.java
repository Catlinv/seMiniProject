package com.example.demo.controllers;

import com.example.demo.domain.Bank;
import com.example.demo.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.MoviesService;

@Controller
public class BankController {
    private BankService bankService;
    static final Bitstream bankKey = new Bitstream("Bank");
    static final Bitstream storeKey = new Bitstream("Store");

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @Autowired
    public void setMovieService(BankService bankService) {
        this.bankService = bankService;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String purchase(@RequestParam("clientId") Long clientId, @RequestParam("storeKey") String sKey, @RequestParam("clientKey") String cKey,
                           @RequestParam("sum") float sum) {
        System.out.println(clientId);
        System.out.println(sKey);
        System.out.println(cKey);
        System.out.println(sum);
        Bank client = bankService.findBankByClientId(clientId);
        if (client == null) return "redirect:http://ecommerce/nullC";
        Bitstream store = new Bitstream(sKey);
        Bitstream clientK = new Bitstream(cKey);
        if (Bitstream.decrypt(clientK, store, BankController.bankKey, "Success").equals(Bitstream.decrypt(new Bitstream(client.getClientKey()), BankController.storeKey, BankController.bankKey, "Success")))
            if (bankService.completePurchase(clientId, sum)) return "redirect:http://ecommerce/succ";
            else return "redirect:http://ecommerce/noFunds";
        return "redirect:http://ecommerce/wrongKey";
    }

}
