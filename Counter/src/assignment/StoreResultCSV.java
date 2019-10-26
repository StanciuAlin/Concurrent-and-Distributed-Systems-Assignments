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
import java.util.concurrent.atomic.AtomicInteger;

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
            resultData = new FileWriter("ValuesForN.csv", true);
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        printWriter = new PrintWriter(resultData);
    }

    /**
     * Write a line in CSV file, the input: n and k, execution time for code sequence and from what requirement comes
     * @param n Number of elements in set
     */
    public static void WriteLine(int n) {
        LocalDateTime dateTime = LocalDateTime.now();                                         //get local date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        printWriter.print("\n" + "n = " + n +  "," + dateTime.format(formatter));
    }

    /**
     * Write a line in CSV file, the input: n and k, execution time for code sequence and from what requirement comes
     * @param n Number of elements in set as an AtomicInteger
     */
    public static void WriteLine(AtomicInteger n) {
        LocalDateTime dateTime = LocalDateTime.now();                                         //get local date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        printWriter.print("\n" + "n = " + n +  "," + dateTime.format(formatter));
    }

    /**
     * A static method to clear the stream of any element that may be or maybe not inside the stream and to close the writing process
     */
    public static void CloseStoring() {
        printWriter.flush();
        printWriter.close();
    }
}