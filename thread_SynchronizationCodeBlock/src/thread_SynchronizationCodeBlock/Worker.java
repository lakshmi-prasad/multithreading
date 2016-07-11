package thread_SynchronizationCodeBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	
	private Object firstLock = new Object();
	private Object secondLock = new Object();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	Random rand = new Random();	

	public void stageOne() {
		synchronized (firstLock) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(rand.nextInt(100));
		}
	}
	
	public  void stageSecond() {
		synchronized (secondLock) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(rand.nextInt(100));
		}
		
	}
	
	public void process() {
		for (int i=0; i<1000; i++) {
			stageOne();
			stageSecond();
		}
	}
	
	public void init() {
		
		System.out.println("starting...");
		
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken: " + (end - start));
		System.out.println("list1 size: " + list1.size() + ", list2 size: " + list2.size());
	}
}
