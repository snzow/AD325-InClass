package Week1.Recursion.ArrayProcessor;
/**
 * The ArrayProcessor program implements an application that
 * will output an array in order, from different configurations.
 *
 * @author  Eric Lloyd
 * @version 1.0
 * @since   2022-09-25
 *
 */

public interface ArrayProcessorInterface {
    /**
     * This method is used to display an array in order by
     * reading it from the front to back.
     * @param array This is the array to be read
     * @param first  This is the first element of the array
     * @param last This is the last element of the array
     * @return Nothing.
     */
    void displayArrayFirst(int array[], int first, int last);

    /**
     * This method is used to display an array in order by
     * reading it from the back to front.
     * @param array This is the array to be read
     * @param first  This is the first element of the array
     * @param last This is the last element of the array
     * @return Nothing.
     */
    void displayArrayLast(int array[], int first, int last);

    /**
     * This method is used to display an array in order by
     * reading from the middle and splitting it.
     * @param array This is the array to be read
     * @param first  This is the first element of the array
     * @param last This is the last element of the array
     * @return Nothing.
     */
    void displayArraySplit(int array[], int first, int last);
}
