package runnable;

public class StartThread {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		
		t1.start();
		t2.start();
	}
}

class Runner implements Runnable {

	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println("counting: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
