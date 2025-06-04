package service;

import entity.Account;
import entity.Bill;
import entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositServiceTest {

    private DepositService depositService;
    private Account account;

    @BeforeEach
    void setUp() {
        depositService = new DepositService();
        Person person = new Person("Amy", "Wong", +123123123);
        Bill bill = new Bill(1200);
        account = new Account(person, bill);
    }

    @Test
    void depositShouldIncreaseBalance() {
        depositService.deposit(account, 50);
        assertEquals(1250, account.getBill().getAmount());
    }

    @Test
    void depositShouldIgnoreNegativeAmount() {
        depositService.deposit(account, -100);
        assertEquals(1200, account.getBill().getAmount()); // игнор
    }

    @Test
    void depositShouldIgnoreNullAccount() {
        depositService.deposit(null, 100);
        assertTrue(true); // просто чтобы тест не упал
    }

}