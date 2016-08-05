package thread_InterruptingThreads;

import java.util.Random;

public class InterruptingThreads {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("starting..");
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Random rand = new Random();
				for (int i=0; i<1E8; i++) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Sir the current thread is interrupted!");
						break;
					}
					Math.sin(rand.nextDouble());
				}
				
			}
		});
		
		t1.start();
		Thread.sleep(500);
		t1.interrupt();
		t1.join();
		System.out.println("Finished!");
	}
}
