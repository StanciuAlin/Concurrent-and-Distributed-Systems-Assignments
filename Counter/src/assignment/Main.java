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

        StoreResultCSV.InitWritingCSV();
        for(int i = 0; i < 10; i++) {
            StoreResultCSV.WriteLine(ConcurrentCounterThread.n);
        }
        StoreResultCSV.CloseStoring();

    }
}
