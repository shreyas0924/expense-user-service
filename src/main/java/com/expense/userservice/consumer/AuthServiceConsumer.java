package com.expense.userservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.AcknowledgeMode;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.expense.userservice.entities.UserInfoDto;
import com.expense.userservice.repository.UserRepository;
import com.expense.userservice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceConsumer {

     @Autowired
     private UserService userService;

     @Autowired
     private ObjectMapper objectMapper;

     @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
     public void listen(UserInfoDto eventData, Acknowledgment acknowledgment) {
          try {
               System.out.println("AuthServiceConsumer: Consumed event: " + eventData);
               // userService.createOrUpdateUser(eventData);
               acknowledgment.acknowledge();
          } catch (Exception ex) {
               ex.printStackTrace();
               System.out.println("AuthServiceConsumer: Exception is thrown while consuming kafka event");
          }
     }

}