package vn.ts5.tattoo.data.model;

import java.io.Serializable;

/**
 * Created by Nani on 2019-08-20.
 */
public class History implements Serializable {
    private String id;
    private String date;
    private String name;
    private int status; //trang thai
    private int rate;   //danh gia
    private long price; //don gia
    private long deposit; // da coc
    private long payment; // da thanh toan
    private long balance; // con lai

    public History(String id, String date, String name, int status, int rate, long price, long deposit, long payment, long balance) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.status = status;
        this.rate = checkRate(rate);
        this.price = price;
        this.deposit = deposit;
        this.payment = payment;
        this.balance = balance;
    }

    private int checkRate(int rate) {
        if(rate > 5){
            return 5;
        }
        else if(rate < 0){
            return 0;
        }
        else return rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = checkRate(rate);
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getPayment() {
        return payment;
    }

    public void setPayment(long payment) {
        this.payment = payment;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
