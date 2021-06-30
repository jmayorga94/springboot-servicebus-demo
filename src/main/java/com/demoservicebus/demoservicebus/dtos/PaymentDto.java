package com.demoservicebus.demoservicebus.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class PaymentDto {
    public String code;
    public String paymentType;
    public BigDecimal value;

}
