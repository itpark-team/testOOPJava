package com.company;

public class Bank {
    private BankClient[] bankClients;

    public Bank() {
        this.bankClients = new BankClient[0];
    }

    public void addClient(BankClient insertedBankClient) {
        BankClient[] tempArray = new BankClient[bankClients.length + 1];

        for (int i = 0; i < bankClients.length; i++) {
            tempArray[i] = bankClients[i];
        }

        tempArray[tempArray.length - 1] = insertedBankClient;

        bankClients = tempArray;
    }

    public void printClientsToConsole() {
        for (int i = 0; i < bankClients.length; i++) {
            System.out.println(bankClients[i].getAsString());
        }
    }

    private BankClient findClientByCardNumber(int cardNumber) throws Exception {
        for (int i = 0; i < bankClients.length; i++) {
            if (bankClients[i].getCardNumber() == cardNumber) {
                return bankClients[i];
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
