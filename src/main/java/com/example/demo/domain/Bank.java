package com.example.demo.domain;

import com.example.demo.controllers.Bitstream;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Data
@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clientID;
    private Bitstream clientKey;
    private float sum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public Bitstream getClientKey() {
        return clientKey;
    }

    public void setClientKey(Bitstream clientKey) {
        this.clientKey = clientKey;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Float.compare(bank.sum, sum) == 0 &&
                Objects.equals(id, bank.id) &&
                Objects.equals(clientID, bank.clientID) &&
                Objects.equals(clientKey, bank.clientKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientID, clientKey, sum);
    }
}
