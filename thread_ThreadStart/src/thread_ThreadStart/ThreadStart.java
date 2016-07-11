package thread_ThreadStart;

class Runner extends Thread {
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

public class ThreadStart {

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.start();
		
		Runner runner1 = new Runner();
		runner1.start();
	}
}
