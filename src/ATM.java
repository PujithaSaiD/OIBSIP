import java.util.Scanner;

public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static int balance = 1000;
    public static void main(String[] args) {
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        int userPin = scanner.nextInt();
        if (authenticateUser(userId, userPin)) {
            showMenu();
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }
    private static boolean authenticateUser(String userId, int userPin) {
        return userId.equals("demo") && userPin == 1234;
    }
    private static void showMenu() {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
    private static void showTransactionHistory() {
        System.out.println("Transaction history not available in demo.");
    }
    private static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds. Withdrawal failed.");
        }
    }
    private static void deposit() {
        System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }
    private static void transfer() {
        System.out.print("Enter recipient's account number: ");
        String recipient = scanner.next();
        System.out.print("Enter amount to transfer: ");
        int amount = scanner.nextInt();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Transfer successful. Remaining balance: " + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds. Transfer failed.");
        }
    }
}