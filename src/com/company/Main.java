package com.company;

public class Main {


    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        bank.addClient(new BankClient(873456, "Иванов Иван Иванович", 10000));
        bank.addClient(new BankClient(456789, "Петров Пётр Петрович", 5000));

        bank.printClientsToConsole();

        bank.sendMoneyFromClientToClient(873456, 456789, 3000);

        bank.printClientsToConsole();

    }
}
