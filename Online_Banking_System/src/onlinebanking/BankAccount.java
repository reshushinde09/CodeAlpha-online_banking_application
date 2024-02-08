package onlinebanking;

public class BankAccount {
	 private String accountNumber;
	    private double balance;

	    public BankAccount(String accountNumber) {
	        this.accountNumber = accountNumber;
	        this.balance = 0;
	    }

	    public String getAccountNumber() {
	        return accountNumber;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	        balance += amount;
	    }

	    public boolean withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            return true;
	        } else {
	            return false;
	        }
	    }

}
