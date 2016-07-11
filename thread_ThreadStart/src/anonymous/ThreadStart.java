package anonymous;

public class ThreadStart {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {

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
			
		});
		t1.start();
	}
}
