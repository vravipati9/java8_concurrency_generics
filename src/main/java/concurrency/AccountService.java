package concurrency;

public class AccountService {
	
	
	public static void transfer(final Account from, final Account to, final int amount){
		System.out.println("<<Transfer begings>>");
		/*try {
			System.out.println(Thread.currentThread().getName());

			to.deposit(amount);
			System.out.println(Thread.currentThread().getName());
			from.withdraw(amount);
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		}
		 */
		
		synchronized (from) {
			System.out.println(Thread.currentThread().getName());
			synchronized (to) {
				System.out.println(Thread.currentThread().getName());
				try {
					if (from.withdraw(amount)) {
						System.out.println(Thread.currentThread().getName());
						to.deposit(amount);
					}
					System.out.println(from.getBalance() + ":" +to.getBalance());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}