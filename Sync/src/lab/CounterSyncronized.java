/**
 * 
 */
package lab;

/**
 * @author Alin Stanciu
 *
 */
public class CounterSyncronized {

	private int value = 0;

    public synchronized void increment() {
    	value++;
    }

    public synchronized int getValue() {
        return value;
    }
	/**
	 * 
	 */
	public CounterSyncronized() {
		// TODO Auto-generated constructor stub
	}

}
