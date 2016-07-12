package thread_NotifyWait;

import java.util.Scanner;

public class Processor {

	public void produce() throws InterruptedException {
		
		synchronized (this) {
			System.out.println("producer thread running..");
			wait();
			System.out.println("producer resumed...");
		}
	}
	
	public void consume() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);

		synchronized (this) {
			System.out.println("Waiting for the return key: ");
			scanner.nextLine();
			System.out.println("return key pressed!");
			notify();
		}
	}
}
