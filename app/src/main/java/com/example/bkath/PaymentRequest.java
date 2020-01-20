package com.example.bkath;

import java.io.Serializable;



/**
 * Created by syed.ahmad on 5/16/2018.
 */

public class PaymentRequest implements Serializable {

    private String amount;
    private String intent;
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "amount='" + amount + '\'' +
                ", intent='" + intent + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }
}
