package service;

import entity.Account;
import entity.Bill;
import entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private PaymentService paymentService;
    private Account account;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentService();
        Person person = new Person("Amy", "Wong", +123123123);
        Bill bill = new Bill(1000);
        account = new Account(person, bill);
    }

    @Test
    void payShouldDownBalance() {
        paymentService.pay(account, 900);
        assertEquals(100, account.getBill().getAmount());
//        assertEquals(200, account.getBill().getAmount());
    }

    @Test
    void payShouldIgnoreNegativeAmount() {
        paymentService.pay(account, -100);
//        assertEquals(1000, account.getBill().getAmount()); // игнор
        assertEquals(1000, account.getBill().getAmount());
    }

    @Test
    void payShouldIgnoreNullAccount() {
        paymentService.pay(null, 0);
        assertTrue(true); // просто чтобы тест не упал
    }
}