package service;

import entity.Account;
import entity.Bill;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class DepositService {

    private static final Logger logger = Logger.getLogger(DepositService.class.getName());
    public void deposit(Account account, int amount) {
        if(account == null || account.getBill() == null) {
            logger.warning("Account or Bill is null");
            return;
        }
        if(amount <= 0) {
            logger.warning("Amount must be greater than 0");
            return;
        }

        Bill bill = account.getBill();

//        System.out.println(account.getPerson().getName() + " your balance is " + bill.getAmount());
        logger.info(account.getPerson().getName() + " your balance is " + bill.getAmount());
        int currentBalance = bill.getAmount();
//        System.out.println("replenishing " + amount + " to current balance: " + currentBalance);
        logger.info("Replenishing " + amount + " to the current balance " + currentBalance);
        currentBalance += amount;
        bill.setAmount(currentBalance);
//        System.out.println(account.getPerson().getName() + " your balance is now " + bill.getAmount());
        logger.info(account.getPerson().getName() + " your balance is now " + bill.getAmount() + "\n******");
    }
}
