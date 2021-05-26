package Threads;

public class Test {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		TestSleep t1 = new TestSleep();
		TestSleep t2 = new TestSleep();
		TestSleep t3 = new TestSleep();
		TestSleep t4 = new TestSleep();
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t4.setName("t4");
		t1.start();
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		t3.start();
		t2.start();
		t4.start();
	}
}

class TestSleep extends Thread {
	public synchronized void run() {
	
		for (int i = 0; i <= 10; i++) {

			try {
				Thread.sleep(500);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
}
