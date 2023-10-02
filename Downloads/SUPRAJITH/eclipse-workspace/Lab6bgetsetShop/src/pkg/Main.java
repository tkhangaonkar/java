package pkg;
import java.util.Queue;
import java.util.LinkedList;


class Shop implements Runnable{
	private boolean avilable=false;
	public void run() {
		while(true) {
			public synchronized int get() 
			{
				while(avilable==false) {
					try 
					{
						Thread.sleep(1500);
						buffer.wait();
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
				int item = itemCount++;
				buffer.add(item);
				System.out.println("Produced "+ item);
				buffer.notifyAll();
				if(item==maxItems) {
					break;
				}
			}
		}
	}	
}

public class Main {
	public static void main(String[] args) {
		Thread pd = new Thread(new Shop());
		Thread cd = new Thread(new Consumer());
		pd.start();
		cd.start();
		try 
		{
			pd.join();
			cd.join();
		}
		catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}
	
}
