import java.util.Scanner;

class Account {
    private double balance;
    private int pin;

    public Account(double initialBalance, int initialPin) {
        this.balance = initialBalance;
        this.pin = initialPin;
    }

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(">>> SUCCESS: $" + amount + " deposited.");
            System.out.println(">>> NEW BALANCE: $" + balance);
        } else {
            System.out.println(">>> ERROR: Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(">>> SUCCESS: Please collect $" + amount);
            System.out.println(">>> NEW BALANCE: $" + balance);
        } else if (amount > balance) {
            System.out.println(">>> ERROR: Insufficient balance!");
        } else {
            System.out.println(">>> ERROR: Invalid withdrawal amount.");
        }
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account userAccount = new Account(5000.0, 1234);

        System.out.println("================================");
        System.out.println("   WELCOME TO JAVA ONLINE ATM   ");
        System.out.println("================================");
        
        System.out.print("ENTER PIN: ");
        int enteredPin = scanner.nextInt();

        if (userAccount.validatePin(enteredPin)) {
            int choice = 0;
            while (choice != 4) {
                System.out.println("\n------- MAIN MENU -------");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit / Logout");
                System.out.print("SELECT OPTION (1-4): ");
                
                choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("CURRENT BALANCE: $" + userAccount.getBalance());
                } 
                else if (choice == 2) {
                    System.out.print("ENTER DEPOSIT AMOUNT: ");
                    double dAmount = scanner.nextDouble();
                    userAccount.deposit(dAmount);
                } 
                else if (choice == 3) {
                    System.out.print("ENTER WITHDRAW AMOUNT: ");
                    double wAmount = scanner.nextDouble();
                    userAccount.withdraw(wAmount);
                } 
                else if (choice == 4) {
                    System.out.println("Logging out... Thank you!");
                } 
                else {
                    System.out.println("Invalid Option. Please try again.");
                }
            }
        } else {
            System.out.println("ACCESS DENIED: Incorrect PIN.");
        }
        scanner.close();
    }
}