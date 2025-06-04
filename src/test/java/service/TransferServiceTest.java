package service;

import entity.Account;
import entity.Bill;
import entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {
    private TransferService transferService;
    private Account accountFrom;
    private Account accountTo;

    @BeforeEach
    void setUp() {
        transferService = new TransferService();
        Person amyPerson = new Person("Amy", "Wong", +123123123);
        Person lilaPerson = new Person("Lila", "Tauranga", +123123123);
        accountFrom = new Account(amyPerson, new Bill(3100));
        accountTo = new Account(lilaPerson, new Bill(1200));
    }

    @Test
    void transferCashSuccesfullFromAccountToAccount() {
        transferService.transferCash(accountFrom, accountTo, 1000);
        assertEquals(2100, accountFrom.getBill().getAmount());
        assertEquals(2200, accountTo.getBill().getAmount());
    }

    @Test
    void transferCashNegotiveFromAccountToAccountNotEnoughMoney() {
        transferService.transferCash(accountFrom, accountTo, 9999);
        assertEquals(3100, accountFrom.getBill().getAmount());
        assertEquals(1200, accountTo.getBill().getAmount());
    }


    @Test
    void transferShouldIgnoreNegativeAmount() {
        transferService.transferCash(accountFrom, accountTo, -100);
        assertEquals(3100, accountFrom.getBill().getAmount()); // игнор
        assertEquals(1200, accountTo.getBill().getAmount());
    }

    @Test
    void transferShouldIgnoreNullAccount() {
        transferService.transferCash(null, null, 0);
        assertTrue(true); // просто чтобы тест не упал
    }
}