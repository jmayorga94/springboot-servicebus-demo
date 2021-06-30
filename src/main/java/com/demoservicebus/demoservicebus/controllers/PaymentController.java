package com.demoservicebus.demoservicebus.controllers;

import com.demoservicebus.demoservicebus.dtos.PaymentDto;
import com.demoservicebus.demoservicebus.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping("payment")
@RestController
public class PaymentController {

    private static final String DESTINATION_NAME = "sbq-monusin-request";

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/pay")
    public ResponseEntity<String> postMessage(@RequestBody PaymentDto paymentDto) {
        log.info("SENDING PAYMENT");

        Payment payment = new Payment(paymentDto.code,paymentDto.paymentType,paymentDto.value);

        jmsTemplate.convertAndSend(DESTINATION_NAME, payment);

        return new ResponseEntity(payment, HttpStatus.ACCEPTED);
    }
}
