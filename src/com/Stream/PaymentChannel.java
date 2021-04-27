package com.Stream;

public class PaymentChannel {
    private String type;
    private String exceptionCode;

    public PaymentChannel(String type, String exceptionCode) {
        this.type = type;
        this.exceptionCode = exceptionCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
