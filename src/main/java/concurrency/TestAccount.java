package concurrency;

public class TestAccount {
	public static void main(String a[]) throws Exception {
		final Account account1 = new Account(1000);
	    final Account account2 = new Account(1000);

/*	    for (int i = 0; i < 2; i++) {
	    	new Thread(() -> {
						try {
							AccountService.transfer(account1, account2, 600);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			}).start();
	    }
	    */
	    //Deadlock situation, Thread1 is waiting for account2 and Thread2 is waiting for account1
	    new Thread(() -> { AccountService.transfer(account1, account2, 600); }).start();
	    new Thread(() -> { AccountService.transfer(account2, account1, 600); }).start();
	    
	    Thread.sleep(1000);
	    System.out.println("!!!!");
	    System.out.println(account1.getBalance());
	    System.out.println(account2.getBalance());
	}
}
