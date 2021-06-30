package com.demoservicebus.demoservicebus.services;

import com.demoservicebus.demoservicebus.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentReceiver {

    private static final String QUEUE_NAME = "sbq-monusin-request";
    private static final String DESTINATION_NAME = "sbq-monusin-response";
    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = QUEUE_NAME)
    public void  processPayment(Payment payment){
        log.info("RECEIVING MESSAGE {} ",payment);
        payment.ProcessMessage();
        log.info("SENDING BACK TO RESPONSE");
        SendToResponseQueue(payment);
        log.info("PAYMENT SENT");
    }

    private void SendToResponseQueue(Payment payment){
        jmsTemplate.convertAndSend(DESTINATION_NAME, payment);
    }
}
