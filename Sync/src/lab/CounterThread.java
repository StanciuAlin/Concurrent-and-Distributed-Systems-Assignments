/**
 * 
 */
package lab;

/**
 * @author Alin Stanciu
 *
 */
public class CounterThread extends Thread {

	CounterSyncronized counter = new CounterSyncronized();
	/**
	 * 
	 */
	public CounterThread() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; ++i) {
			counter.increment();
			System.out.println("Counter = " + counter.getValue());
		}
		
	}

	
}
