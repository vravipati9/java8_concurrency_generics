package concurrency;



public class Account {
	  private int balance;

	  public Account(final int initialBalance) {
	    balance = initialBalance;
	  }

	  public synchronized void deposit(final int amount) throws Exception {
	          if (amount > 0) 
	        	  balance += amount;
	  }

	  public synchronized boolean withdraw(final int amount) throws Exception {
	          if (amount > 0 && balance >= amount)  {
	            balance -= amount;
	            return true;
	          }
	          return false;
	  }

	public synchronized int getBalance() {
		return balance;
	}
	  
}