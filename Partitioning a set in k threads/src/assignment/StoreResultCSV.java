/**
 * @author Stanciu Alin Marian
 * @date 25.10.2019
 * @version v1.0
 */
package assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class to manage writing process in a CSV file
 */
public class StoreResultCSV {

    /**
     * A string with table header
     */
    static String header = "N,K,Time (ms),Requirement,Time(hh:mm:ss)";
    /**
     * A variable for writing streams of characters
     */
    static FileWriter resultData;
    /**
     * A variable for prints formatted representation of objects to a text-output stream
     */
    static PrintWriter printWriter;

    /**
     * Empty constructor
     */
    public StoreResultCSV() {

    }

    /**
     * Init connection with CSV file in order to write later
     */
    public static void InitWritingCSV() {
        try {
            resultData = new FileWriter("ExecutionTimeData.csv", true);
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        printWriter = new PrintWriter(resultData);
    }

    /**
     * Write a line in CSV file, the input: n and k, execution time for code sequence and from what requirement comes
     * @param n Number of elements in set
     * @param k Number of threads
     * @param executionTime Execution time for n elements divided in k threads to find all prime numbers
     * @param requirement 1 for problem 1, part 1 and 2 for problem 1 part 2
     */
    public static void WriteLine(int n, int k, long executionTime, int requirement) {
        LocalDateTime dateTime = LocalDateTime.now();                                         //get local date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        printWriter.print("\n" + "n = " + n + "," + "k = " + k + "," + "Exe time = " + executionTime + " ms" + "," + "Requirement = " + requirement + "," + dateTime.format(formatter));
    }

    /**
     * A static method to clear the stream of any element that may be or maybe not inside the stream and to close the writing process
     */
    public static void CloseStoring() {
        printWriter.flush();
        printWriter.close();
    }
}
