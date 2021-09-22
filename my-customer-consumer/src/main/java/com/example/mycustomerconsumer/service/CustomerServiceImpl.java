package com.example.mycustomerconsumer.service;

import com.example.mycustomerconsumer.dao.CustomerDao;
import com.example.mycustomerconsumer.model.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return customerDao.save(customerEntity);
    }
}
