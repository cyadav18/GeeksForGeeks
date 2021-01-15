package com.geeksforgeeks.analysis;

public class Test implements Runnable {
	
	private static int i = 0;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test p1 = new Test();
		Test p2 = new Test();
		Test p3 = new Test();
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		t1.run();
		t2.run();
		p3.display();

	}

	@Override
	public void run() {
		increment();
	}
	public synchronized  void increment() {
		
		System.out.println("previous value of i "+i);
		i = i+1;
	}
	public void display() {
		System.out.println(i);
	}
}
/* 
 * 
 * class A{
 *  print();
 * }
 * 
 * class B extends A{
 *  print();
 * }
 * 
 * PrintMethod(A a){
 *  a.print();
 * }
 * 
 */

