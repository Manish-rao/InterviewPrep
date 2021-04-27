package com.PerformanceCheck;

public class RandomClass {
    private int bankName;
    private int instrNum;
    private int accNum;

    public RandomClass(int bankName, int instrNum, int accNum) {
        this.bankName = bankName;
        this.instrNum = instrNum;
        this.accNum = accNum;
    }

    public int getBankName() {
        return bankName;
    }

    public void setBankName(int bankName) {
        this.bankName = bankName;
    }

    public int getInstrNum() {
        return instrNum;
    }

    public void setInstrNum(int instrNum) {
        this.instrNum = instrNum;
    }

    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }
}
