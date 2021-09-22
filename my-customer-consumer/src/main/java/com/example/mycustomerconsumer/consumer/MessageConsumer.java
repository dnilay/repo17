package com.example.mycustomerconsumer.consumer;

import com.example.mycustomerconsumer.dto.CustomerDto;
import com.example.mycustomerconsumer.model.CustomerEntity;
import com.example.mycustomerconsumer.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@EnableJms
@RestController
public class MessageConsumer {
    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
    private CustomerService customerService;
    private ModelMapper modelMapper;
    String str;
    private CustomerDto customerDto;
    @Autowired
    public MessageConsumer(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @JmsListener(destination = "test-queue")
   public void listener(String customerDto){
        logger.info("Message (Object) received {} ", customerDto);
      this.str=customerDto;

    }
    @PostMapping("/customers")

    public ResponseEntity<CustomerEntity> createCustomer()
    {
        logger.info("Message (Object) received {} ", str);

        String[] arr=str.split("-");
        CustomerDto customerDto1=new CustomerDto();
        customerDto1.setCustomerId(Integer.parseInt(arr[0]));
        customerDto1.setCustomerName(arr[1]);
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
      CustomerEntity customerEntity=modelMapper.map(customerDto1,CustomerEntity.class);
      customerService.createCustomer(customerEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerEntity);
    }
}
