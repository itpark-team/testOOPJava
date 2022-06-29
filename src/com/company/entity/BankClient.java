package com.company.entity;

public class BankClient {
    private int cardNumber;
    private String fcs;
    private double money;

    public BankClient(int cardNumber, String fcs, double money) {
        this.cardNumber = cardNumber;
        this.fcs = fcs;
        this.money = money;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getAsString() {
        return String.format("номер карты = %d; ФИО = %s; денег на счету = %.2f", cardNumber, fcs, money);
    }

    public void sendMoney(BankClient bankClientTo, double moneyTo) throws Exception {
        if (moneyTo > money) {
            throw new Exception("incorrect money value. value too much");
        }

        bankClientTo.money += moneyTo;
        money -= moneyTo;
    }

    public void addMoney(double money) throws Exception {
        if (money <= 0) {
            throw new Exception("incorrect money value. value too small or negative");
        }

        this.money += money;
    }
}
