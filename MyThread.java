class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("Thread is running...");
            // Simulate an exception
            throw new Exception("An error occurred in the thread");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

public class ThreadExceptionHandling {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
