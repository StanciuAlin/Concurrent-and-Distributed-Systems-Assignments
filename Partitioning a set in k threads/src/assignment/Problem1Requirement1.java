/**
 * @author Stanciu Alin Marian
 * @date 25.10.2019
 * @version v1.0
 */
package assignment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Class which solve requirement 1 for problem 1
 */
public class Problem1Requirement1 implements IStopwatch, IRandomGenerator, IPartition {
    /**
     * Initial value for stopwatch variable for counting milliseconds
     */
    static long startTime = 0;
    /**
     * Initial value for stopwatch variable needed to stop counter and retain last clock value
     */
    static long stopTime = 0;
    /**
     * Input value, n is superior limit for given range [1, n] (number of elements in set)
     */
    private int n = 0;
    /**
     * Input value, k is the number of thread desired to implement to solve requirement
     */
    private int k = 0;

    /**
     * Constructor set an initial value for n and k
     */
    public Problem1Requirement1() {
        this.k = 0;
        this.n = 0;
    }

    /**
     * Getter for n value
     * @return Value of n
     */
    public int getN() {
        return n;
    }

    /**
     * Getter for k value
     * @return Value of k
     */
    public int getK() {
        return k;
    }

    /**
     * Solution for req1
     */
    public void ExecuteReq() {
        SetValues();                        //set random values for n and k
        StartTimerExecution();              //start the stopwatch

        int q = n / k;                      //the quotient of n divided by k
        int r = n % k;                      //the reminder of n divided by k
        ArrayList<Integer> partition = new ArrayList<Integer>(q + 1); //retain all set [1, n]

        int iterator = 1;
        for(iterator = 1; iterator <= r; ++iterator) {            //for first r thread implement one general term

            Thread thread = new PrimeNumThread(0,
                    q,
                    ConstructPartition((iterator - 1) * q + iterator, iterator * q + iterator));
            thread.start();                                       //start the current thread
            try {
                thread.join();                                    //join and wait untill all threads are finished
            } catch (InterruptedException ex) {
                ex.getStackTrace();
            }
        }
        iterator--;
        while(iterator < k) {                                     //while we do not have all k thread created
            Thread thread = new PrimeNumThread(0,      //create new thread with other general term
                    q - 1,
                    ConstructPartition(iterator * q + r + 1, (iterator + 1) * q + r));
            thread.start();                                      //start the current thread
            try {
                thread.join();                                   //join and wait all threads are finished
            } catch (InterruptedException ex) {
                ex.getStackTrace();
            }
            iterator++;
        }
        StopTimerExecution();                                    //stop counter
        PrintExecutionTime();                                    //print total execution time in terminal

        //store n, k and execution time for every run of problem 1, requirement 1 in a CSV file
        StoreResultCSV.WriteLine(this.n, this.k, GetLastTimeExecutionMillis(), 1);
    }

    /**
     * Construct a set with all consecutive values from leftMargin to rightMargin and return it
     * @param leftMargin Inferior limit
     * @param rightMargin Superior limit
     * @return A set with all consecutive numbers in [leftMargin, rightMargin]
     */
    @Override
    public ArrayList<Integer> ConstructPartition(int leftMargin, int rightMargin) {
        int iterator;
        ArrayList<Integer> partition = new ArrayList<Integer>(rightMargin - leftMargin + 1);
        for(iterator = leftMargin; iterator <= rightMargin; ++iterator) {
            partition.add(iterator);
        }
        return partition;
    }

    /**
     * Not implemented
     * @param m The Array
     * @return A matrix with k lines, and at most k colons, with m set partitioned by algorithm, but not implemented
     */
    @Override
    public Integer[][] ConstructPartition(ArrayList<Integer> m) {
        return null;
    }

    /**
     * Get and set random values for n and k variables
     */
    @Override
    public void SetValues() {
        Random rand = new Random();
        do {
            this.n = rand.nextInt(10000);     //value may be bigger than 10000, but is set equal with max range from Problem1Requirement1
            this.k = rand.nextInt(10000);     //value may be bigger than 10000, but is set equal with max range from Problem1Requirement1
        }while(k >= n);
        //this.n = 22;
        //this.k = 5;
    }

    /**
     * Print execution time in terminal with a message and surrounded with *
     */
    @Override
    public void PrintExecutionTime() {
        System.out.println("\t\t\t\t\t************************************************************");
        System.out.print("\t\t\t\t\t* Total time execution for problem 1, a is " + GetLastTimeExecutionMillis() + " ms *\n");
        System.out.println("\t\t\t\t\t************************************************************");
    }

    /**
     * Start counter
     */
    @Override
    public void StartTimerExecution() {
        startTime = System.nanoTime();
    }

    /**
     * Stop counter
     */
    @Override
    public void StopTimerExecution() {
        stopTime = System.nanoTime();
    }

    /**
     * Get execution time in milliseconds
     * @return Execution time
     */
    @Override
    public long GetLastTimeExecutionMillis() {
        return TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
    }
}
