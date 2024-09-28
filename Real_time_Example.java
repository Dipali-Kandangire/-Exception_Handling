import java.util.InputMismatchException;
import java.util.Scanner;

// Custom Exception for Insufficient Funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance! Current balance: " + balance);
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
        }
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.00);  // Initial balance is 1000.00

        while (true) {
            try {
                System.out.println("\n==== Banking Menu ====");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Choose an option (1-4): ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1: // Deposit
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 2: // Withdraw
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;

                    case 3: // Check balance
                        System.out.println("Your current balance is: " + account.getBalance());
                        break;

                    case 4: // Exit
                        System.out.println("Exiting the system. Thank you for using our service!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please choose between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException: Please enter a valid number.");
                scanner.next();  // Clear the invalid input
            } catch (InsufficientFundsException e) {
                System.out.println("InsufficientFundsException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
// Custom Exception: InsufficientFundsException handles insufficient balance scenarios.

// Menu-Driven: User-friendly banking system with deposit, withdrawal, balance inquiry, and exit options.

// Input Validation: Catches invalid input with InputMismatchException and ensures positive amounts for transactions.

// Real-World Simulation: Simulates basic banking tasks with proper exception handling.

// Separation of Concerns: Clear division between bank operations and user interface.

// Graceful Exit: Allows the program to close cleanly and properly manages resources.

// User Feedback: Clear messages for errors like invalid inputs and insufficient funds.
