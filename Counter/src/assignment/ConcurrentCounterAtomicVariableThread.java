/**
 * @author Stanciu Alin Marian
 * @date 25.10.2019
 * @version v1.0
 */
package assignment;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentCounterAtomicVariableThread extends Thread {
    /**
     * Number to increment concurrently (atomic variable)
     */
    static AtomicInteger n = new AtomicInteger(0);
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
        AtomicInteger temp;
        for(int i = 0; i < 10; i++) {
            temp = n;
            temp.addAndGet(1);
            n = temp;
        }
    }
}
