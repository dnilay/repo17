package com.example.mycustomerconsumer;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableEurekaClient
public class MyCustomerConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCustomerConsumerApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
    @Bean // Serialize message content to json using TextMessage
    public MappingJackson2MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
