package pkg;

import java.util.Queue;
import java.util.LinkedList;

public class MainProducerConsumerDemo1 {
    private static final Queue<Integer> buffer = new LinkedList<>();
    private static int itemCount = 0;
    public static final int bufferSize = 1;
    public static final int maxItems = 15;

    public static class Producer implements Runnable {
        public void run() {
            while (true) {
                synchronized (buffer) {
                    while (buffer.size() == bufferSize) {
                        waitFor(buffer, 1500);
                    }
                    int item = itemCount++;
                    buffer.add(item);
                    System.out.println("Produced " + item);
                    buffer.notifyAll();
                    if (item == maxItems) {
                        break;
                    }
                }
            }
        }
    }

    public static class Consumer implements Runnable {
        public void run() {
            while (true) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        waitFor(buffer, 500);
                    }
                    int item = buffer.poll();
                    System.out.println("Consumed " + item);
                    buffer.notifyAll();
                    if (item == maxItems) {
                        break;
                    }
                }
            }
        }
    }

    private static void waitFor(Object obj, long milliseconds) {
        try {
            Thread.sleep(milliseconds);
            obj.wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Thread pd = new Thread(new Producer());
        Thread cd = new Thread(new Consumer());
        pd.start();
        cd.start();
        try {
            pd.join();
            cd.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
