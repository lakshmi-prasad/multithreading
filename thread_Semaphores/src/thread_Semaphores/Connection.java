package thread_Semaphores;

import java.util.concurrent.Semaphore;

public class Connection {

	private static Connection conn = new Connection();
	private int connections = 0;
	private Semaphore sem = new Semaphore(10, true);
	
	private Connection () {}
	
	public static Connection getInstance () {
		return conn;
	}
	
	public void connect() {
	
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		try {
			doConnect();
		} finally {
			sem.release();
		}
	}
	
	public void doConnect()  {
		
		synchronized (this) {
			++this.connections;
			System.out.println("entering connect() : " + this.connections);
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (this) {
			--this.connections;
			System.out.println("exiting connect(): " + this.connections);
		}
	}
}
