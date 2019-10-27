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
 * Class to solve problem 1, requirement 2
 */
public class Problem1Requirement2 implements IStopwatch, IRandomGenerator, IPartition {

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
    public Problem1Requirement2() {
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
        SetValues();
        StartTimerExecution();

        int q = n / k;
        int r = n % k;
        ArrayList<Integer> m = new ArrayList<>(n);
        int iterator;
        for(iterator = 0; iterator <= n; ++iterator) {
            m.add(iterator);
        }
        for(iterator = 2; iterator * (k + 1) <= m.size(); ++iterator ) {
            //m.remove(iterator * (k + 1) - 1);
            m.remove(iterator * (k + 1));
        }


        Integer[][] setPartitioned = new Integer[k+1][k];
        setPartitioned = ConstructPartition(m);

        for(iterator = 1; iterator <= k; ++iterator) {
            Integer[] c = new Integer[k - 1];
            c = setPartitioned[iterator];
            //create thread
            Thread thread = new PrimeNumThread(0,
                    c.length - 1,
                    convertIntArrayToList(c));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException ex) {
                ex.getStackTrace();
            }
        }

        StopTimerExecution();
        PrintExecutionTime();

        StoreResultCSV.WriteLine(this.n, this.k, GetLastTimeExecutionMillis(), 2);
    }

    /**
     * Function to convert from Integer[] to ArrayList of Integer
     * @param input An array of Integer
     * @return An ArrayList which corresponding with input array
     */
    private static ArrayList<Integer> convertIntArrayToList(Integer[] input) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>(input.length);   //new variable ArrayList type

        for (Integer iterator : input) {                                       //iterate in input with an Integer object
            arrayList.add(iterator);                                           //add it to new ArrayList variable
        }

        return arrayList;                                                      //after all values were added, return it
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
     * Print execution time in terminal with a message and surrounded with *
     */
    @Override
    public void PrintExecutionTime() {
        System.out.println("\t\t\t\t\t************************************************************");
        System.out.print("\t\t\t\t\t* Total time execution for problem 1, b is " + GetLastTimeExecutionMillis() + " ms *\n");
        System.out.println("\t\t\t\t\t************************************************************");
    }

    /**
     * Get execution time in milliseconds
     * @return Execution time
     */
    @Override
    public long GetLastTimeExecutionMillis() {
        return TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
    }

    /**
     * Get and set random values for n and k variables
     */
    @Override
    public void SetValues() {
        Random rand = new Random();
        do {
            this.n = rand.nextInt(1000000);   //value bigger overflow Java heap, because of using static array
            this.k = rand.nextInt(1000) + 2;   //value bigger overflow Java heap, because of using static array
        }while(k >= n);
//        this.n = 100;
//        this.k = 5;
    }

    /**
     * Not implemented
     * @param leftMargin Inferior limit
     * @param rightMargin Superior limit
     * @return A set with all consecutive numbers in [leftMargin, rightMargin], but not implemented
     */
    @Override
    public ArrayList<Integer> ConstructPartition(int leftMargin, int rightMargin) {
        return null;
    }

    /**
     * Construct a set with k subsets, every subset contains at most k elements with all consecutive values from m array and return it
     * @param m The Array
     * @return A matrix with k lines, and at most k colons, with m set partitioned by algorithm
     */
    @Override
    public Integer[][] ConstructPartition(ArrayList<Integer> m) {

        Integer[][] m_j = new Integer[k + 1][n];                                     //in m_j retain the k partitions of set m

        if (m.indexOf(this.k + 1) != -1) {                                          //check k + 1 values exist in m set
            int numberOfThreads = m.get(m.indexOf(this.k + 1));                    //if exist, get it
            m_j[1][0] = numberOfThreads;
            m.remove(numberOfThreads);                                             //and remove it from set
        }

        //partitioning the initial set in k subsets

        for(int iteratorSubSet = 0; iteratorSubSet < k; ++iteratorSubSet) {        //iterate in all k threads to create his subset
            for(int iteratorThread = 0; iteratorThread < n; ++iteratorThread) {    //iterate in every thread to the maximum k-th value
                //m_j[iteratorThread][iteratorSubSet] = m.get(indexElementSet++);
                int currentValue = (k + 1) * iteratorThread + iteratorSubSet + 1;  //retain the value which follow problem statement
                if (currentValue <= n) {                                           //if this value is less or equal than maximum possible value, n
                    m_j[iteratorSubSet + 1][iteratorThread] = currentValue;        //add it in iteratorSubSet Thread subset
                }
            }
        }
        //by problem statement, k + 1 value belong M1 subset         //by convention (problem statement), value k + 1 belong to Thread 1

        return m_j;                                                                //return all k threads with values partitioned from m array
    }
}
