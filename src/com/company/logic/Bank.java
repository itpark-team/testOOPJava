package com.company.logic;

import com.company.entity.BankClient;

import java.util.ArrayList;

public class Bank {
    private ArrayList<BankClient> bankClients;
    private int lastCardNumber;

    public Bank() {
        bankClients = new ArrayList<>();
        lastCardNumber = 111111;
    }

    //region utils methods
    private void addClientToList(BankClient insertedBankClient) {
        bankClients.add(insertedBankClient);
    }

    private BankClient findClientByCardNumber(int cardNumber) throws Exception {
        for (int i = 0; i < bankClients.size(); i++) {
            if (bankClients.get(i).getCardNumber() == cardNumber) {
                return bankClients.get(i);
            }
        }
        throw new Exception("client with cardNumber " + cardNumber + " not found");
    }

    public String getClientsAsString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < bankClients.size(); i++) {
            stringBuilder.append(bankClients.get(i).getAsString());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
    //endregion

    public void addClient(String fcs) {
        lastCardNumber++;
        addClientToList(new BankClient(lastCardNumber, fcs, 0));
    }

    public void sendMoneyFromClientToClient(int cardNumberFrom, int cardNumberTo, double moneyTo) throws Exception {
        BankClient bankClientFrom = findClientByCardNumber(cardNumberFrom);
        BankClient bankClientTo = findClientByCardNumber(cardNumberTo);

        bankClientFrom.sendMoney(bankClientTo, moneyTo);
    }

    public void addMoneyToClient(int cardNumber, double money) throws Exception {
        BankClient bankClient = findClientByCardNumber(cardNumber);
        bankClient.addMoney(money);
    }

}
