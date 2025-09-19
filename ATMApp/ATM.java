import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    System.out.printf("Current balance: %.2f%n", account.getBalance());
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleWithdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 4.");
            }
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = getDoubleInput();
        if (account.deposit(amount)) {
            System.out.printf("Deposit successful. New balance: %.2f%n", account.getBalance());
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = getDoubleInput();
        if (account.withdraw(amount)) {
            System.out.printf("Withdrawal successful. New balance: %.2f%n", account.getBalance());
        }
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline
        return value;
    }

    private double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume leftover newline
        return value;
    }

    public static void main(String[] args) {
        Scanner initScanner = new Scanner(System.in);
        System.out.print("Enter initial account balance: ");
        double initialBalance;

        while (true) {
            if (initScanner.hasNextDouble()) {
                initialBalance = initScanner.nextDouble();
                initScanner.nextLine();
                break;
            } else {
                System.out.print("Invalid amount. Enter a number: ");
                initScanner.next();
            }
        }

        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);
        atm.start();

        initScanner.close();
    }
}
