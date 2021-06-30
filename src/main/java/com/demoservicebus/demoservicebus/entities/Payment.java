package com.demoservicebus.demoservicebus.entities;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Payment implements Serializable {

    private static final long serialVersionUID = -295422703255886286L;

    public String code;
    public String paymentType;
    public BigDecimal value;
    public Boolean processed;

    public Payment(String code, String paymentType, BigDecimal value)
    {
      this.code = code;
      this.paymentType = paymentType;
      this.value = value;
    }

    public void ProcessMessage()
    {
        processed = true;
    }
}
