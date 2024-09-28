class MyRunnable implements Runnable {
    private String threadName;

    MyRunnable(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadName + " is running...");
            // Simulate some processing
            for (int i = 1; i <= 5; i++) {
                if (i == 3 && threadName.equals("Thread-2")) {
                    // Simulate an exception for Thread-2
                    throw new Exception(threadName + " encountered an error at iteration " + i);
                }
                System.out.println(threadName + " - Iteration: " + i);
                Thread.sleep(500);  // Simulate some work by sleeping
            }
        } catch (Exception e) {
            System.out.println("Exception caught in " + threadName + ": " + e.getMessage());
        }
    }
}

public class MultiThreadExceptionHandling {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable("Thread-1"));
        Thread t2 = new Thread(new MyRunnable("Thread-2"));
        Thread t3 = new Thread(new MyRunnable("Thread-3"));

        // Start the threads
        t1.start();
        t2.start();
        t3.start();
    }
}
