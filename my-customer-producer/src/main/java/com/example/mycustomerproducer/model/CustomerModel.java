package com.example.mycustomerproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerModel implements Serializable {
    private Integer customerId;
    private String customerName;

    @Override
    public String toString() {
        return customerId+"-"+customerName;
    }
}
