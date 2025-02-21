package bank;

public class Account {
    private String owner;
    private double balance;
    private NotificationService notificationService;

    public Account(String owner, double balance, NotificationService notificationService) {
        this.owner = owner;
        this.balance = balance;
        this.notificationService = notificationService;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            notificationService.notify(owner, "Depósito de R$ " + amount + " realizado com sucesso.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            notificationService.notify(owner, "Saque de R$ " + amount + " realizado com sucesso.");
            return true;
        }
        return false;
    }
}