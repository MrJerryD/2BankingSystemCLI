import entity.Account;
import entity.Bill;
import entity.Person;

public class Main {
    public static void main(String[] args) {

        Person amy = new Person("Amy", "Wong", +123123123);
        Bill amyBill = new Bill(1200);
        Account amyAccount = new Account(amy, amyBill);

        Person lila = new Person("Bob", "Tauranga", +123123123);
        Bill lilaBill = new Bill(700);
        Account lilaAccount = new Account(lila, lilaBill);

    }
}
