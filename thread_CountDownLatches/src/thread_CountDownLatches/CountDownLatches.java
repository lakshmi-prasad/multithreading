package thread_CountDownLatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatches {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for (int i=0; i<3; i++) {
			executor.submit(new Processor(latch));
		}
		
		try {
			latch.await(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("completed!");
	}
}

class Processor implements Runnable {
	
	private CountDownLatch latch ;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		System.out.println("started ..");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		latch.countDown();
	}
}
