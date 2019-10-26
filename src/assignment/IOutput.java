/**
 * @author Stanciu Alin Marian
 * @date 25.10.2019
 * @version v1.0
 */
package assignment;

import java.util.ArrayList;

/**
 * This interface is specialised for print in terminal different content specified as parameter in every function
 */
public interface IOutput {
    /**
     * Print a steady message for the problem context
     */
    void Print();

    /**
     * Print a custom message said with message parameter
     * @param message Custom input message
     */
    void Print(String message);

    /**
     * Print an array specified as parameter
     * @param array Input array
     */
    void Print(ArrayList<Integer> array);
}
