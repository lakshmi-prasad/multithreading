package thread_Deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private Account ac1 = new Account();
	private Account ac2 = new Account();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	private void acquireLock(Lock firstLock, Lock secondLock) throws InterruptedException {
		
		while (true) {
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			
			try {
				gotFirstLock = firstLock.tryLock();
				gotSecondLock = secondLock.tryLock();
			} finally {
				if (gotFirstLock && gotSecondLock) {
					return;
				}
				if (gotFirstLock) {
					firstLock.unlock();
				}
				if (gotSecondLock) {
					secondLock.unlock();
				}
			}
			Thread.sleep(1);
		}
	}
	
	public void firstThread() throws InterruptedException {
		
		Random rand = new Random();
		for (int i=0; i<1000; i++) {
//			lock1.lock();
//			lock2.lock();
			acquireLock(lock1, lock2);
			try {
				Account.transfer(ac1, ac2, rand.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
			
		}
	}
	
	public void secondThread() throws InterruptedException {
		Random rand = new Random();
		for (int i=0; i<1000; i++) {
//			lock2.lock();
//			lock1.lock();
			acquireLock(lock2, lock1);
			try {
				Account.transfer(ac2, ac1, rand.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	public void finished() {
		System.out.println("account 1 balance: " + ac1.getBalance());
		System.out.println("account 2 balance: " + ac2.getBalance());
		System.out.println("total balance: " + (ac1.getBalance() + ac2.getBalance()));
	}
}
