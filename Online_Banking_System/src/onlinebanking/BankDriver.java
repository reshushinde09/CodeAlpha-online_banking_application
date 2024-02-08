package onlinebanking;

import java.util.Scanner;

public class BankDriver {
	public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    if (bank.createAccount(accountNumber)) {
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Account already exists!");
                    }
                    break;

                case 2:
                    performTransaction(bank, scanner, true);
                    break;

                case 3:
                    performTransaction(bank, scanner, false);
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    BankAccount account = (BankAccount) bank.getAccount(accountNumber);

                    if (account != null) {
                        System.out.println("Balance: $" + account.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void performTransaction(Bank bank, Scanner scanner, boolean isDeposit) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = (BankAccount) bank.getAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter amount: $");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            if (isDeposit) {
                account.deposit(amount);
                System.out.println("Deposit successful. New balance: $" + account.getBalance());
            } else {
                if (account.withdraw(amount)) {
                    System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
                } else {
                    System.out.println("Insufficient balance or invalid withdrawal amount.");
                }
            }
        } else {
            System.out.println("Account not found!");
        }
    }

}
