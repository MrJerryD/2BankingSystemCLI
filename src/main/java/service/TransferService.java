package service;

import entity.Account;

import java.util.Scanner;
import java.util.logging.Logger;

import entity.Bill;

public class TransferService {

    private static final Logger logger = Logger.getLogger(DepositService.class.getName());

    public void transferCash(Account from, Account to, int amount) {
        if (from == null || to == null || from.getBill() == null || to.getBill() == null) {
            logger.warning("Please enter a valid account");
            return;
        }

        if (amount <= 0 || amount > from.getBill().getAmount()) {
            logger.warning("Please enter a valid transfer amount");
            return;
        }

        Bill fromBill = from.getBill();
        Bill toBill = to.getBill();

        if (fromBill.getAmount() < amount) {
//            System.out.println("You don't have enough money to transfer.");
            logger.warning("You don't have enough money to transfer.");
        } else {
            fromBill.setAmount(fromBill.getAmount() - amount);
            toBill.setAmount(toBill.getAmount() + amount);
//            System.out.println("Transfer successful. " +
//                    "\nOn the balance " + from.getPerson().getName() + " " + fromBill.getAmount() + "$ and "
//                    + to.getPerson().getName() + " " + toBill.getAmount() + "$");
            logger.info("Transfer successful. " +
                    "\nOn the balance " + from.getPerson().getName() + " " + fromBill.getAmount() + "$ and "
                    + to.getPerson().getName() + " " + toBill.getAmount() + "$");
        }
    }


//    public void transferCash(Account from, Account to) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("How much cash do you want to transfer?");
//        int userAmountCash;
//
//        try{
//            userAmountCash = scanner.nextInt();
//        }catch (Exception e){
//            System.out.println("Please enter a valid number");
//            return;
//        }
//        if(userAmountCash < 0){
//            System.out.println("Please enter a positive number");
//            return;
//        }
//
//        Bill fromBill = from.getBill();
//        Bill toBill = to.getBill();
//
//        if(fromBill.getAmount() < userAmountCash) {
//            System.out.println("You don't have enough money to transfer.");
//        }else {
//            fromBill.setAmount(fromBill.getAmount() - userAmountCash);
//            toBill.setAmount(toBill.getAmount() + userAmountCash);
//            System.out.println("Transfer successful. " +
//                    "\nOn the balance " + from.getPerson().getName() + " " + fromBill.getAmount() + "$ and "
//                    + to.getPerson().getName() + " " + toBill.getAmount() + "$");
//        }
//
//    }
}
