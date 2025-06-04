package main;

import entity.Account;
import entity.Bill;
import entity.Person;
import service.DepositService;
import service.PaymentService;
import service.TransferService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initial
        Person amy = new Person("Amy", "Wong", +123123123);
        Bill amyBill = new Bill(1200);
        Account amyAccount = new Account(amy, amyBill);

        Person lila = new Person("Lila", "Tauranga", +123123123);
        Bill lilaBill = new Bill(700);
        Account lilaAccount = new Account(lila, lilaBill);

        PaymentService paymentService = new PaymentService();
        DepositService depositService = new DepositService();
        TransferService transferService = new TransferService();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Пополнение");
            System.out.println("2 - Оплата");
            System.out.println("3 - Перевод");
            System.out.println("0 - Выход");

            String userInput = scanner.nextLine();
            switch (userInput){
                case "1" ->{
                    System.out.print("Сколько хотите пополнить? ");
                    int amount = Integer.parseInt(scanner.nextLine());
                    depositService.deposit(amyAccount, amount);
                }
                case "2" -> {
                    System.out.print("Сколько хотите оплатить? ");
                    int amount = Integer.parseInt(scanner.nextLine());
                    paymentService.pay(amyAccount, amount);
                }
                case "3" -> {
                    System.out.print("Сколько хотите перевести? ");
                    int amount = Integer.parseInt(scanner.nextLine());
                    transferService.transferCash(amyAccount, lilaAccount, amount);
                }
                case "0" -> {
                    System.out.println("Пока!");
                    return;
                }
                default -> System.out.println("Неверный ввод");
            }
        }


//        Person amy = new Person("Amy", "Wong", +123123123);
//        Bill amyBill = new Bill(1200);
//        Account amyAccount = new Account(amy, amyBill);
//
//        Person lila = new Person("Lila", "Tauranga", +123123123);
//        Bill lilaBill = new Bill(700);
//        Account lilaAccount = new Account(lila, lilaBill);

//        PaymentService paymentService = new PaymentService();
//        paymentService.pay(amyAccount, 1000);
//        paymentService.pay(lilaAccount, 2000);

//        DepositService depositService = new DepositService();
//        depositService.deposit(amyAccount, -10);
//        depositService.deposit(lilaAccount, 1111);

//        TransferService transferService = new TransferService();
//        transferService.transferCash(amyAccount, lilaAccount, 1000);

    }
}