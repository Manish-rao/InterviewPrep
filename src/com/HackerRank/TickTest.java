package com.HackerRank;

public class TickTest  {
    private String instr;
    private double price;
    private long time;

    public TickTest(String instr, double price, long time) {
        this.instr = instr;
        this.price = price;
        this.time = time;
    }

    public String getInstr() {
        return instr;
    }

    public void setInstr(String instr) {
        this.instr = instr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
