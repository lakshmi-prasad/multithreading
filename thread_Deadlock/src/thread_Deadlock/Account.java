package thread_Deadlock;

public class Account {

	private int balance = 1000;
	
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	public void withdraw(int amount) {
		this.balance -= amount;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public static void transfer(Account ac1, Account ac2, int amount) {
		ac1.withdraw(amount);
		ac2.deposit(amount);
	}
}
