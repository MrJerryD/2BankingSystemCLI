package service;

import entity.Account;
import entity.Bill;

import java.util.logging.Logger;

public class PaymentService {
    private final Logger logger = Logger.getLogger(PaymentService.class.getName());

    public void pay(Account account, int amount) {
        if((account == null) || (account.getBill() == null)) {
            logger.warning("Account or Bill is null");
            return;
        }
        if(amount <= 0) {
            logger.warning("Amount must be greater than 0");
            return;
        }

        Bill bill = account.getBill();

        if (bill.getAmount() < amount) {
            logger.warning("It isn't enough money on your account");
        } else {
            logger.info("Your balance is " + bill.getAmount());
            bill.setAmount(bill.getAmount() - amount);
            logger.info("Your account has been payed successfully\n" +
                    "Your balance is: " + bill.getAmount() + "\n******");
        }
    }
}
