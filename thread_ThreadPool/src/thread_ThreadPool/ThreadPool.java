package thread_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for (int i=0; i<5; i++) {
			executor.submit(new Processor(i));
		}
		
		executor.shutdown();
		
		System.out.println("all tasks submitted successfully!");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks DONE!");
	}
}


class Processor implements Runnable {
	
	private int id;
	
	public Processor(int id) {
		this.id = id;
	}
	
	public void run() {
		System.out.println("starting id: " + this.id);
		
		try {
            Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("ending id: " + this.id);
	}
}
