/**
 * @author Stanciu Alin Marian
 * @date 25.10.2019
 * @version v1.0
 */
package assignment;

import java.util.ArrayList;

/**
 * Special class which extends Thread class and find all prime numbers in a range
 */
public class PrimeNumThread extends Thread implements IPrime, IOutput {
    /**
     * For a range, represent inferior limit
     */
    private int leftMargin;
    /**
     * For a range, represent superior limit
     */
    private int rightMargin;
    /**
     * Keep all values given in constructor
     */
    private ArrayList<Integer> partition = new ArrayList<Integer>(0);
    /**
     * Will keep all prime numbers from partition array
     */
    private ArrayList<Integer> allPrimeNumberFromPartition = new ArrayList<Integer>(0);

    /**
     * Constructor which set initial values for class member variables
     * @param leftMargin Inferior limit
     * @param rightMargin Superior limit
     * @param partition A specific set with natural numbers
     */
    public PrimeNumThread(int leftMargin, int rightMargin, ArrayList<Integer> partition) {
        this.leftMargin = leftMargin;
        this.rightMargin = rightMargin;
        this.partition = partition;
    }

    /**
     * Necessary to implement thread action
     * Intially print Thread info and then take every value from partition array and check if it is prime
     * only if value on that position is different by null
     * After the array is finished, is printed the array which contains all prime numbers
     */
    @Override
    public void run() {
        System.out.println("\t\t-------------------> Thread name: " + Thread.currentThread().getName() + ", State:" + Thread.currentThread().getState()
                + " <---------------------------");
        for(int iterator = leftMargin; iterator <= rightMargin; ++iterator) {
            if(partition.get(iterator) != null) {
                if(IsPrime(partition.get(iterator))) {
                    //add to all prime numbers
                    allPrimeNumberFromPartition.add(partition.get(iterator));
                }
            }
        }
        //print all prime numbers
        Print(allPrimeNumberFromPartition);
    }

    /**
     * Check if a number is prime
     * A prime number is a number which has only 2 divisors, 1 and itself
     * @param value The number to check if it is prime
     * @return Return A logical state: 1 (true) if the given value is a prime number, otherwise 0 (false)
     */
    @Override
    public boolean IsPrime(int value) {

        int divisor = 2;                               //try all number with divisor role, starting with 2
        boolean flagPrime = true;                      //flag to block search if a number is divided with a value

        while(divisor <= value / 2 && flagPrime) {
            if (value % divisor == 0) {                //primality condition is break, and prime number flag become false
                flagPrime = false;
            }
            divisor++;                                 //go to next divisor
        }
        if (flagPrime && value != 1) {
            return true;                               //prime flag remain true after all divisions and then value is prime
        }
        return false;                                  //given value is not a prime number
    }

    /**
     * Print "active" message
     */
    @Override
    public void Print() {
        System.out.println("active");
    }

    /**
     * Print a given message
     * @param message Input message
     */
    @Override
    public void Print(String message) {
        System.out.println(message);
    }

    /**
     * Print an array in terminal starting with a short message
     * @param array Input array
     */
    @Override
    public void Print(ArrayList<Integer> array) {
        System.out.print("\t\t\t\t\t\t\tThread found next prime numbers: ");
        for(int iterator = 0; iterator < array.size(); ++iterator) {
            System.out.print(array.get(iterator) + " ");
        }
        System.out.print("\n\n");
    }
}
