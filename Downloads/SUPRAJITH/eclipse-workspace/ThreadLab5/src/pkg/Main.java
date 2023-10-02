package pkg;
import java.io.PrintStream;
import java.util.*;

class Thread1 extends Thread{
	public void run() {
		System.out.println("Thread 1 Started ");

		for(int i=0;i<=5;i++) {
			System.out.println("Thread 1 : "+ i);
			try {
				Thread.sleep(2000);
			}
			catch ( Exception e ){
//				System.out.println(e);
				e.printStackTrace();

			}
		}
		
	}
}



class Thread2 extends Thread{

//	System.out.println("Thread 2 is running");
//	System.out.println();
	public void run() {
		for(int i=10;i<=20;i++) {
			System.out.println("Thread 2 : "+ i);
			try {
				Thread.sleep(2000);
				

			}
			catch ( Exception e ){
//				System.out.println(e);
				e.printStackTrace();

			}
		}
		
	}
}



class Thread3 implements Runnable{
	@Override
	public void run() {
		System.out.println("Thread 3 Started ");

		for(int i=0;i<=50;i++) {
			System.out.println("Thread 3 Using Runnable : "+ i);
//			if (i==40) {
//				Thread.join();
//			}

			try {
				Thread.sleep(200);
			}
			catch ( Exception e ){
//				System.out.println(e);
				e.printStackTrace();


			}
		}
		
	}
}



public class Main  {

	@SuppressWarnings("deprecation")
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		Runnable thr = new Thread3();
		
		Thread t3=new Thread(thr);
//		System.out.println(t3.getState()+"T 3");

		t1.start();
		System.out.println(t1.getState()+" T 1");

		t2.start();
		System.out.println(t2.getState()+" T 2");

		try {
			
			t2.sleep(1500);
		}
		catch(Exception e) {
//			System.out.println("Exeption "+e);
			System.out.println("Exeption in T2 sleep");

			e.printStackTrace();

		}
		System.out.println(t3.getState()+"T 3");

		t3.start();
		//Inturrupton
		
//		t3.interrupt();

//		try {
//			t3.interrupt();
//			System.out.println(t3.getState()+"T 3");
//		}
//		catch (InterruptedException e) {
//			System.out.println(t3.getState()+"T 3");
//			e.getStackTrace();
//		}
//		try {
//			t3.wait();
//			System.out.println(t3.getState()+"T 3");
//
//		}
//		catch(Exception e) {
//			System.out.println("Exeption in wait");
////			System.out.println(t3.getStackTrace());
////			e.printStackTrace();
//
//		}
//		t3.sleep(1000);
		try {
			System.out.println(t3.getState()+"T 3");

//			t3.wait(50);
			t3.yield();

		}
		catch(Exception e) {
			System.out.println(t3.getState()+"T 3");

			System.out.println("Exeption in wait : "+e);
//			System.out.println(t3.getStackTrace());
//			e.printStackTrace();

		}

	}

}
