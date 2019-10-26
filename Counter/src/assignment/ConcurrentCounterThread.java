/**
 * @author Stanciu Alin Marian
 * @date 26.10.2019
 * @version v1.0
 */
package assignment;

public class ConcurrentCounterThread extends Thread {
    /**
     * Number to increment concurrently
     */
    static volatile int n = 0;
    /**
     * If this thread was constructed using a separate
     * {@code Runnable} run object, then that
     * {@code Runnable} object's {@code run} method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of {@code Thread} should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        int temp;
        for(int i = 0; i < 10; i++) {
            temp = n;
            n = temp + 1;
        }
    }
}
