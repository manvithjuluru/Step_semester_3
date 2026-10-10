package class_problems;
import java.util.LinkedHashMap;
import java.util.Map;
abstract class Account {
    String id;
    protected int balance;
    Account(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }
    abstract String withdraw(int amount);
}
class SavingsAccount extends Account {
    SavingsAccount(String id, int balance) { super(id, balance); }
    String withdraw(int amount) {
        if (balance - amount < 1000) {
            return id + " rejected: minimum balance 1000";
        }
        balance -= amount;
        return id + " balance " + balance;
    }
}
class CurrentAccount extends Account {
    CurrentAccount(String id, int balance) { super(id, balance); }
    String withdraw(int amount) {
        if (balance - amount < -5000) {
            return id + " rejected: overdraft limit 5000";
        }
        balance -= amount;
        return id + " balance " + balance;
    }
}
public class Problem1 {
    public static void main(String[] args) {
        String[] input = {
                "Savings S1 5000",
                "WITHDRAW S1 4500",
                "Current C1 2000",
                "WITHDRAW C1 6000",
                "WITHDRAW S1 3000",
                "WITHDRAW C1 2000"
        };
        Map<String, Account> accounts = new LinkedHashMap<>();
        for (String line : input) {
            String[] p = line.split(" ");
            switch (p[0]) {
                case "Savings":
                    accounts.put(p[1], new SavingsAccount(p[1], Integer.parseInt(p[2])));
                    break;
                case "Current":
                    accounts.put(p[1], new CurrentAccount(p[1], Integer.parseInt(p[2])));
                    break;
                case "WITHDRAW":
                    Account acc = accounts.get(p[1]);
                    if (acc == null) {
                        System.out.println("Account not found");
                    } else {
                        System.out.println(acc.withdraw(Integer.parseInt(p[2])));
                    }
                    break;
            }
        }
    }
}