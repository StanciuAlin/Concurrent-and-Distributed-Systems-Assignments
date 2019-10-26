/**
 * @author Stanciu Alin Marian
 * @date 25.10.2019
 * @version v1.0
 */
package assignment;

public class Main {
    /**
     * Solve concurrent counting problem
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        ConcurrentCounterThread p = new ConcurrentCounterThread();
        ConcurrentCounterThread q = new ConcurrentCounterThread();

        p.start();
        q.start();

        try {
            p.join();
            q.join();
        }
        catch (InterruptedException ex) {
            ex.getStackTrace();
        }
//        System.out.println(ConcurrentCounterThread.n);
//        test condition
        if(ConcurrentCounterThread.n != 20) {
            throw new IllegalArgumentException("The value for n is incorrect");
        }

        StoreResultCSV.InitWritingCSV();
        for(int i = 0; i < 10; i++) {
            StoreResultCSV.WriteLine(ConcurrentCounterThread.n);
        }
        StoreResultCSV.CloseStoring();

    }
}
