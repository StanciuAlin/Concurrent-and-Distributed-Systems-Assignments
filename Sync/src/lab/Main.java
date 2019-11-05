/**
 * 
 */
package lab;

/**
 * @author Alin Stanciu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CounterThread thread1 = new CounterThread();
		CounterThread thread2 = new CounterThread();
		
		thread1.start();
		thread2.start();
	}

}
