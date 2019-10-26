/**
 * @author Stanciu Alin Marian
 * @date 25.10.2019
 * @version v1.0
 */
package assignment;

/**
 * Interface is specific for prime numbers
 */
public interface IPrime {
    /**
     * Check if a given value is a prime number
     * @param value The number to check if it is prime
     * @return A logical state: 1 (true) if the given value is a prime number, otherwise 0 (false)
     */
    boolean IsPrime(int value);
}
