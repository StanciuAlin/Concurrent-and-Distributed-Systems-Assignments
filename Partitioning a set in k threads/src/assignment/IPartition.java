/**
 * @author Stanciu Alin Marian
 * @date 25.10.2019
 * @version v1.0
 */
package assignment;

import java.util.ArrayList;

/**
 * Interface contain 2 partition function which implement different algorithms specific for every statement
 */
public interface IPartition {

    /**
     * Take inferior and superior limit for a range and implement a partition algorithm
     * @param leftMargin Inferior limit
     * @param rightMargin Superior limit
     * @return An ArrayList which contains a set partitioned
     */
    ArrayList<Integer> ConstructPartition(int leftMargin, int rightMargin);

    /**
     * Take an array and implement a partition algorithm
     * @param m The Array
     * @return A matrix which contains a set partitioned according to algorithm
     */
    Integer[][] ConstructPartition(ArrayList<Integer> m);

}
