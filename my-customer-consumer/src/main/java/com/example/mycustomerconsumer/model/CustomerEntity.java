package com.example.mycustomerconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cuctomer_table")
public class CustomerEntity {
    @Id
    @Column(name="customer_id")
    private Integer customerId;
    @Column(name="customer_name")
    private String customerName;
}
