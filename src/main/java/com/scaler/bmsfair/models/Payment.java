package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.PaymentProvider;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel{
    private String transactionNumber;
    private PaymentProvider paymentProvider;

}
