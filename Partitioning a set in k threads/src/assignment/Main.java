/**
 * @author Stanciu Alin Marian
 * @date 25.10.2019
 * @version v1.0
 */
package assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Print problem statement in terminal
     */
    private static void PrintStatement1a() {
        System.out.println("\n**************************************************" +
                "********** Statement 1, part 1 *************************************************************");
        System.out.println("\n\t\tFind all prime numbers in [1,n] using k threads. Let n =" +
                "kq + r, where 0 ≤ r <k where r is the remainder of n divided to k. \n\t\tPartition the interval [1,n] in k intervals as follows: I1=[1,q+1], I2=[q+2,\n" +
                "\t2q+2], . . . , Ir=[(r-1)q+r, rq+r], Ir+1=[rq+r+1, (r+1)q+r], ..., Ik=[(k-1)q+r+1," +
                "kq+r]. Each thread 1 ≤ j ≤ k will determine the prime numbers in the interval " +
                "Ij\n");
        System.out.println("\t\t\t\t\t[1, n] interval partitioned in k intervals, one for every thread\n");
    }

    /**
     * Print problem statement in terminal
     */
    private static void PrintStatement1b() {
        System.out.println("\n\n**************************************************" +
                "********** Statement 1, part 2 *************************************************************");
        System.out.println("\n\t\t\tThe multiples of k+1 strictly bigger than k+1 are not prime numbers. These\n" +
                "\t\tnumbers should be eliminated from the interval [1,n] resulting in set M. This\n" +
                "\t\tset should be partitioned in k subsets as follows: for each 1 ≤ j ≤ k the set Mj\n" +
                "\t\tcontains all those elements from M who by divided with k+1 give remainder j.\n" +
                "\t\t\tAlso it is considered that k+1 belongs to M1. Each thread j will determine the\n" +
                "\t\tprime numbers from set Mj");
        System.out.println("\t\t\t\t\t[1, n] interval partitioned in k intervals, one for every thread\n");
    }

    /**
     * Print title for lab homework
     */
    private static void PrintFirstPage() {
        System.out.println("*****************************************************************" +
                "******************************************************************************");
        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tConcurrency Model Lab Assignment\n\n\n");
        System.out.println("*****************************************************************" +
                "******************************************************************************");
    }

    /**
     * Read a value from user which is an option for which algorithm to use
     * @return The value given by user
     */
    private static int ReadOptionFromUser() {

        int option = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\tPlease select an option: \n" +
                "\tFor problem 1 part 1 insert value \"1\"\n" +
                "\tFor problem 1 part 2 insert value \"2\"\n" +
                "\tFor exit insert \"3\"\n");
        System.out.print("\t\tThe option is: ");
        try {
            option = scanner.nextInt();
        } catch (Exception ex) {
            ex.getStackTrace();
        }

        return option;
    }

    /**
     * This manage user chooses and execute desired algorithm
     * @return A logical state: true if user choose to execute one algorithm or false if user choose to exit
     * @throws InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity, necessary for sleep() method
     */
    private static boolean ChooseAction() throws InterruptedException {
        int option = ReadOptionFromUser();                                    //this is user option
        switch (option) {
            case 1: {                                                         //choose algorithm 1
                PrintStatement1a();
                Problem1Requirement1 problem1 = new Problem1Requirement1();
                problem1.ExecuteReq();
                break;
            }
            case 2: {                                                         //choose algorithm 2
                PrintStatement1b();
                Problem1Requirement2 problem2 = new Problem1Requirement2();
                problem2.ExecuteReq();
                break;
            }
            case 3: {                                                        //choose to exit from application
                System.out.println("-----------------------------------------------------> Exit <------------------------------" +
                        "-----------------------");
                Thread.sleep(1000);
                return false;
            }
        }

        return true;
    }

    /**
     * Init a writer for writing in a CSV file
     */
    private static void StartWriteOperationOnCSVFile() {
        StoreResultCSV.InitWritingCSV();
    }

    /**
     * Close storing process from a current CSV file
     */
    private static void CloseWriteOperationOnCSVFile() {
        StoreResultCSV.CloseStoring();
    }

    /**
     * This is the starting point for lab assignment
     * If you want to test the output, uncomment from 134 to 142 line and run the app
     * @param args Main function command line arguments
     */
    public static void main(String[] args) {

        PrintFirstPage();
        StartWriteOperationOnCSVFile();

        boolean flag = true;
        do {
            try {
                flag = ChooseAction();

                /*
                 * Uncomment only if you want to test output
                 */
//                TestOutput test = new TestOutput();
//                ArrayList<ArrayList<Integer> > aList = new ArrayList<ArrayList<Integer>>();
//                boolean Test = test.testOutput(PrimeNumThread.outputAllPrimeNumbersSaved);
//                if (Test) {
//                    System.out.println("Output OK");
//                }
//                else {
//                    System.out.println("Output NOK");
//                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(flag);

        CloseWriteOperationOnCSVFile();
        //System.out.println("At the end, there are k threads created" );
    }
}
