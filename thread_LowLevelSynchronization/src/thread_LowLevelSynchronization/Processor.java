package thread_LowLevelSynchronization;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (lock) {
				while (list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
	}
	
	public void consume() throws InterruptedException {
		Random rand = new Random();
		
		while (true) {
			synchronized (lock) {
				while (list.size() == 0) {
					lock.wait();
				}
				System.out.print("list size: " + list.size());
				Integer val = list.removeFirst();
				System.out.println("; value: " + val);
				lock.notify();
			}
			Thread.sleep(rand.nextInt(1000));
		}
	}
}
