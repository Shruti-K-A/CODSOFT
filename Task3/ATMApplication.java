import java.util.Scanner;

// ATM Machine class created first
class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(double startingBalance) {
        userAccount = new BankAccount(startingBalance);
        scanner = new Scanner(System.in);
    }

    // Method to show menu
    private void displayMenu() {
        System.out.println("\n======= ATM MACHINE =======");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    // Method to run the ATM machine
    public void run() {
        boolean continueUsing = true;

        while (continueUsing) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + userAccount.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmt = scanner.nextDouble();
                    if (depositAmt > 0) {
                        userAccount.deposit(depositAmt);
                    } else {
                        System.out.println("Invalid amount. Must be positive.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmt = scanner.nextDouble();
                    if (withdrawAmt > 0) {
                        userAccount.withdraw(withdrawAmt);
                    } else {
                        System.out.println("Invalid amount. Must be positive.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    continueUsing = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
}

// Bank Account class second
class BankAccount {
    private double balance;

    public BankAccount(double initialAmount) {
        this.balance = initialAmount;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println( amount + " deposited.");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Withdrawal failed. Not enough balance.");
        } else {
            balance -= amount;
            System.out.println( amount + " withdrawn.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Main class last — calls ATM
public class ATMApplication {
    public static void main(String[] args) {
        ATM atmMachine = new ATM(4000); // Creating ATM with starting balance
        atmMachine.run(); // Start the ATM machine
    }
}
