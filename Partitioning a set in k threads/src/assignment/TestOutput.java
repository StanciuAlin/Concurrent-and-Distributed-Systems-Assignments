/**
 * @author Stanciu Alin Marian
 * @date 27.10.2019
 * @version v1.0
 */
package assignment;

import java.util.ArrayList;

/**
 * Class to test the output of the prime numbers problem from set [1, n] partitioning in k subsets
 */
public final class TestOutput implements IPrime{
    /**
     * A function to test the output
     * Check for every output value if it is a prime number
     * If the number is not prime, the function return false and the test is failed, otherwise the function
     * return true and the test is passed
     * @param output Input array of array which represent the output from the problem
     * @return True if all numbers are prime or false if at least one is non prime
     */
    public boolean testOutput(ArrayList<ArrayList<Integer>> output) {

        if(output.size() == 0) {
            throw new IllegalArgumentException("Empty output");
        }
        for(int iterator = 0; iterator < output.size(); ++iterator) {
            if(output.get(iterator).size() > 0) {
                for(int j = 0; j < output.get(iterator).size(); j++) {
                    if(!IsPrime(output.get(iterator).get(j))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Check if a given value is a prime number
     * @param value The number to check if it is prime
     * @return A logical state: 1 (true) if the given value is a prime number, otherwise 0 (false)
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
}
