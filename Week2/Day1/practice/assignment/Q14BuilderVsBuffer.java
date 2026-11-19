package practice.assignment;

public class Q14BuilderVsBuffer {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        StringBuffer sbf = new StringBuffer();

        for (int i = 0; i < 1000; i++) {
            sb.append("a");
            sbf.append("a");
        }

        System.out.println("Single-thread lengths -> StringBuilder: " + sb.length() + ", StringBuffer: " + sbf.length());

        // Multithreaded test on shared StringBuilder (unsynchronized; may throw exceptions or lose updates)
        StringBuilder sharedBuilder = new StringBuilder();
        Runnable builderTask = () -> {
            for (int i = 0; i < 1000; i++) {
                sharedBuilder.append("x");
            }
        };

        Thread t1 = new Thread(builderTask);
        Thread t2 = new Thread(builderTask);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Shared StringBuilder length (expected 2000): " + sharedBuilder.length());

        // Multithreaded test on shared StringBuffer (synchronized methods; thread-safe)
        StringBuffer sharedBuffer = new StringBuffer();
        Runnable bufferTask = () -> {
            for (int i = 0; i < 1000; i++) {
                sharedBuffer.append("x");
            }
        };

        Thread t3 = new Thread(bufferTask);
        Thread t4 = new Thread(bufferTask);
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("Shared StringBuffer length (expected 2000): " + sharedBuffer.length());
    }
}