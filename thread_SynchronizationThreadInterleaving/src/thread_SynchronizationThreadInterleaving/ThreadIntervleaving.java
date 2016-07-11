package thread_SynchronizationThreadInterleaving;

public class ThreadIntervleaving {
	
	private int count = 0;
	
	public synchronized void increment() {
		++count;
	}

	public static void main(String[] args) {
		ThreadIntervleaving ti = new ThreadIntervleaving();
		
		ti.doWork();
	}
	
	public void doWork() {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i=0; i<100000; i++) {
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i=0; i<100000; i++) {
					increment();
				}
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
		
		System.out.println("count: " + count);
	}
}
