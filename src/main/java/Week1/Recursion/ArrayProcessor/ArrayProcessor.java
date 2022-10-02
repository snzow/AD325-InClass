package Week1.Recursion.ArrayProcessor;
/**
 * {@inheritDoc}
 */

public class ArrayProcessor implements ArrayProcessorInterface {

    public void displayArrayFirst(int array[], int first, int last){
        System.out.print(array[first] + " ");
        if (first < last)
            displayArrayFirst(array, first+1, last);
    }

    public void displayArrayLast(int array[], int first, int last){
        if (first <= last) {
            displayArrayLast(array, first, last - 1);
            System.out.print(array[last] + " ");
        }
    }


    public void displayArraySplit(int array[], int first, int last){
        if (first == last) {
            System.out.print(array[first] + " ");
        }
        else {
            int mid = (first + (last - first) / 2);
            displayArraySplit(array, first, mid);
            displayArraySplit(array, mid + 1, last);
        }
    }

}
