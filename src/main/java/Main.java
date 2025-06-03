import entity.Account;
import entity.Bill;
import entity.Person;
import service.DepositService;
import service.PaymentService;
import service.TransferService;

public class Main {
    public static void main(String[] args) {

        Person amy = new Person("Amy", "Wong", +123123123);
        Bill amyBill = new Bill(1200);
        Account amyAccount = new Account(amy, amyBill);

        Person lila = new Person("Lila", "Tauranga", +123123123);
        Bill lilaBill = new Bill(700);
        Account lilaAccount = new Account(lila, lilaBill);

//        PaymentService paymentService = new PaymentService();
//        paymentService.pay(amyAccount, 1000);

//        DepositService depositService = new DepositService();
//        depositService.deposit(amyAccount, -2000);
//        depositService.deposit(lilaAccount, 1111);

        TransferService transferService = new TransferService();
        transferService.transferCash(amyAccount, lilaAccount);

    }
}