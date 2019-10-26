/**
 * @author Stanciu Alin Marian
 * @date 25.10.2019
 * @version v1.0
 */
package assignment;

/**
 * Interface to count execution time for a code
 */
public interface IStopwatch {
    /**
     * Start counter now
     */
    void StartTimerExecution();

    /**
     * Stop counter now
     */
    void StopTimerExecution();

    /**
     * After stop execution is called, we can print total time execution in ms
     */
    void PrintExecutionTime();

    /**
     * Getter for total time execution if it is necessary outside the class
     * @return Time exectution in ms as long type value
     */
    long GetLastTimeExecutionMillis();
}
