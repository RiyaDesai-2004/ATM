import java.util.Scanner;

class BankAccount {
    private double bal;

    public BankAccount(double bal) {
        this.bal = bal;
    }

    public String withdraw(double amount) {
        if (amount > bal) {
            return "Insufficient balance";
        }
        bal-= amount;
        return "Withdrawal successful. Remaining balance: " + bal;
    }

    public String deposit(double amount) {
        bal+= amount;
        return "Deposit successful. New balance: " + bal;
    }

    public String checkBalance() {
        return "Current balance: " + bal;
    }
}

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayOptions();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(account.withdraw(withdrawAmount));
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(account.deposit(depositAmount));
                    break;
                case 3:
                    System.out.println(account.checkBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.run();
    }
}

