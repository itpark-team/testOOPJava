package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();

        bank.addClient("Иванов Иван Иванович");
        bank.addClient("Петров Пётр Петрович");

        bank.printClientsToConsole();
    }
}
