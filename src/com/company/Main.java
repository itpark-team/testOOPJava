package com.company;

import com.company.logic.Bank;

import java.util.Scanner;

public class Main {

    static int inputInt(String message, int min, int max) {
        boolean isValidInput;
        int output = 0;
        do {
            try {
                isValidInput = true;
                Scanner scanner = new Scanner(System.in);

                System.out.print(message);
                output = scanner.nextInt();

                if (output < min || output > max) {
                    System.out.println("Ошибка ввода. Вы вышли за границы диапазона от " + min + " до " + max);
                    throw new Exception();
                }

            } catch (Exception e) {
                isValidInput = false;
                System.out.println("Ошибка ввода. Пожалуйста повторите ввод");
            }

        } while (isValidInput == false);

        return output;
    }

    static double inputDouble(String message, double min, double max) {
        boolean isValidInput;
        double output = 0;
        do {
            try {
                isValidInput = true;
                Scanner scanner = new Scanner(System.in);

                System.out.print(message);
                output = scanner.nextDouble();

                if (output < min || output > max) {
                    System.out.println("Ошибка ввода. Вы вышли за границы диапазона от " + min + " до " + max);
                    throw new Exception();
                }

            } catch (Exception e) {
                isValidInput = false;
                System.out.println("Ошибка ввода. Пожалуйста повторите ввод");
            }

        } while (isValidInput == false);

        return output;
    }

    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();

        bank.addClient("Иванов Иван Иванович");
        bank.addClient("Петров Пётр Петрович");

        while (true) {
            System.out.println(bank.getClientsAsString());
            System.out.println("-------");

            System.out.println("1.Пополнить счёт по номеру карты");
            System.out.println("2.Перевести деньги с карты на карту");
            System.out.println("0.Выход");

            int chosenMenuPoint = inputInt("Выберите пункт меню: ", 0, 2);

            switch (chosenMenuPoint) {
                case 1: {
                    int cardNumber = inputInt("Введите номер карты: ", 111111, 999999);
                    double money = inputDouble("Введите деньги: ", 1, 500000);

                    bank.addMoneyToClient(cardNumber, money);
                }
                break;
                case 2: {
                    int cardNumberFrom = inputInt("Введите номер карты отправителя: ", 111111, 999999);
                    int cardNumberTo = inputInt("Введите номер карты получателя: ", 111111, 999999);
                    double moneyTo = inputDouble("Введите деньги для получателя: ", 1, 500000);

                    bank.sendMoneyFromClientToClient(cardNumberFrom, cardNumberTo, moneyTo);
                }
                break;
                case 0: {
                    System.exit(0);
                }
                break;
            }
        }
    }
}
