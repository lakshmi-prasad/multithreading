package example1;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		Processor p1 = new Processor();
		
		p1.start();
		
		System.out.println("press return to stop..");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		p1.shutdown();
	}
	
}


class Processor extends Thread {
	
	private volatile boolean running = true;
	
	public void run() {
		
		while (running) {
			System.out.println("hello manib");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		running = false;
	}
}
