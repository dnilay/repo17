package com.example.mycustomerconsumer.dao;

import com.example.mycustomerconsumer.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity,Integer> {
}
