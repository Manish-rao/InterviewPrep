package com.Stream;

public class BankAcc {
    private PaymentChannel paymentChannel;

    public BankAcc(PaymentChannel paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public PaymentChannel getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(PaymentChannel paymentChannel) {
        this.paymentChannel = paymentChannel;
    }
}
