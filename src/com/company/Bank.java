package com.company;

import java.util.ArrayList;

public class Bank {
    private ArrayList<BankClient> bankClients;
    private int lastCardNumber;

    public Bank() {
        bankClients = new ArrayList<>();
        lastCardNumber = 111111;
    }

    private void addClientToList(BankClient insertedBankClient) {
        bankClients.add(insertedBankClient);
    }

    public void addClient(String fcs) {
        lastCardNumber++;
        addClientToList(new BankClient(lastCardNumber, fcs, 0));
    }

    public void printClientsToConsole() {
        for (int i = 0; i < bankClients.size(); i++) {
            System.out.println(bankClients.get(i).getAsString());
        }
    }

    private BankClient findClientByCardNumber(int cardNumber) throws Exception {
        for (int i = 0; i < bankClients.size(); i++) {
            if (bankClients.get(i).getCardNumber() == cardNumber) {
                return bankClients.get(i);
            }
        }
        throw new Exception("client with cardNumber " + cardNumber + " not found");
    }

    public void sendMoneyFromClientToClient(int cardNumberFrom, int cardNumberTo, int moneyTo) throws Exception {
        BankClient bankClientFrom = findClientByCardNumber(cardNumberFrom);
        BankClient bankClientTo = findClientByCardNumber(cardNumberTo);

        bankClientFrom.sendMoney(bankClientTo, moneyTo);
    }
}
