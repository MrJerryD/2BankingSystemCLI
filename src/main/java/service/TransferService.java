package service;

import entity.Account;

import java.util.Scanner;
import entity.Bill;

public class TransferService {

    public void transferCash(Account from, Account to) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much cash do you want to transfer?");
        int userAmountCash;

        try{
            userAmountCash = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Please enter a valid number");
            return;
        }
        if(userAmountCash < 0){
            System.out.println("Please enter a positive number");
            return;
        }

        Bill fromBill = from.getBill();
        Bill toBill = to.getBill();

        if(fromBill.getAmount() < userAmountCash) {
            System.out.println("You don't have enough money to transfer.");
        }else {
            fromBill.setAmount(fromBill.getAmount() - userAmountCash);
            toBill.setAmount(toBill.getAmount() + userAmountCash);
            System.out.println("Transfer successful. " +
                    "\nOn the balance " + from.getPerson().getName() + " " + fromBill.getAmount() + "$ and "
                    + to.getPerson().getName() + " " + toBill.getAmount() + "$");
        }

    }
}
