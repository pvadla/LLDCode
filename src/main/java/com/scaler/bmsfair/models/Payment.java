package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.PaymentProvider;

public class Payment extends BaseModel{
    private String transactionNumber;
    private PaymentProvider paymentProvider;

}
