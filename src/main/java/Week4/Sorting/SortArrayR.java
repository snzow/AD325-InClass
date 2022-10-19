package Week4.Sorting;

public class SortArrayR {

    // SELECTION SORT
    public static <T extends Comparable<? super T>>
    void selectionSortR(T[] a, int n)
    {
        selectionSortR(a, 0, n - 1); // invoke recursive method
    } // end selectionSort

    public static <T extends Comparable<? super T>> void selectionSortR(T[] a, int first, int last)
    {
        if (first < last)
        {  // Place the smallest value at beginning of array:
            int indexOfNextSmallest = getIndexOfSmallest(a, first, last);
            swap(a, first, indexOfNextSmallest);
            selectionSortR(a, first + 1, last);
        } // end if
    } // end selectionSort

    // Returns the index of the smallest value in a portion of an array.
    private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last)
    {
        T min = a[first];
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++)
        {
            if (a[index].compareTo(min) < 0)
            {
                min = a[index];
                indexOfMin = index;
                // Assertion: min is the smallest of a[first] through a[index].
            } // end if
        } // end for
        return indexOfMin;
    } // end getIndexOfSmallest

    // INSERTION SORT
    public static <T extends Comparable<? super T>>
    void insertionSort(T[] a, int n)
    {
        insertionSort(a, 0, n - 1);
    } // end insertionSort

    public static <T extends Comparable<? super T>>
    void insertionSort(T[] a, int first, int last)
    {
        if (first < last)
        {
            // Sort all but the last entry
            insertionSort(a, first, last - 1);

            // Insert the last entry in sorted order
            insertInOrder(a[last], a, first, last - 1);
        } // end if
    } // end insertionSort

    // Inserts element into the sorted array elements a[begin] through a[end].
    private static <T extends Comparable<? super T>>
    void insertInOrder(T element, T[] a, int begin, int end)
    {
        if (element.compareTo(a[end]) >= 0)
            a[end + 1] = element;
        else if (begin < end)
        {
            a[end + 1] = a[end];
            insertInOrder(element, a, begin, end - 1);
        }
        else
        {
            a[end + 1] = a[end];
            a[end] = element;
        } // end if
    } // end insertInOrder

    // MERGE SORT
    public static <T extends Comparable<? super T>>
    void mergeSort(T[] a, int n)
    {
        mergeSort(a, 0, n - 1);
    } // end mergeSort

    public static <T extends Comparable<? super T>>
    void mergeSort(T[] a, int first, int last)
    {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[])new Comparable<?>[a.length]; // unchecked cast
        mergeSort(a, tempArray, first, last);
    } // end mergeSort

    private static <T extends Comparable<? super T>>
    void mergeSort(T[] a, T[] tempArray, int first, int last)
    {
        if (first < last)
        {  // sort each half
            int mid = first + (last - first) / 2;  // Index of midpoint
            mergeSort(a, first, mid);              // Sort left half array[first..mid]
            mergeSort(a, mid + 1, last);           // Sort right half array[mid+1..last]

            if (a[mid].compareTo(a[mid + 1]) > 0)      // Question 2, Chapter 9
                merge(a, tempArray, first, mid, last);  // merge the two halves
            //	else skip merge step
        }  // end if
    }  // end mergeSort

    private static <T extends Comparable<? super T>>
    void merge(T[] a, T[] tempArray, int first, int mid, int last)
    {
        // Two adjacent subarrays are a[beginHalf1..endHalf1] and a[beginHalf2..endHalf2].
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid + 1;
        int endHalf2 = last;

        // While both subarrays are not empty, copy the
        // smaller item into the temporary array
        int index = beginHalf1; // Next available location in tempArray
        for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
        {  // Invariant: tempArray[beginHalf1..index-1] is in order

            if (a[beginHalf1].compareTo(a[beginHalf2]) < 0)
            {
                tempArray[index] = a[beginHalf1];
                beginHalf1++;
            }
            else
            {
                tempArray[index] = a[beginHalf2];
                beginHalf2++;
            }  // end if
        }  // end for

        // Finish off the nonempty subarray

        // Finish off the first subarray, if necessary
        for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
            // Invariant: tempArray[beginHalf1..index-1] is in order
            tempArray[index] = a[beginHalf1];

        // Finish off the second subarray, if necessary
        for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
            // Invariant: tempa[beginHalf1..index-1] is in order
            tempArray[index] = a[beginHalf2];

        // Copy the result back into the original array
        for (index = first; index <= last; index++)
            a[index] = tempArray[index];
    }  // end merge

    // QUICK SORT
    /** Sorts an array into ascending order. Uses quick sort with
     median-of-three pivot selection for arrays of at least
     MIN_SIZE entries, and uses insertion sort for other arrays. */
    public static <T extends Comparable<? super T>>
    void quickSort(T[] array, int n)
    {
        quickSort(array, 0, n - 1);
    } // end quickSort

    public static <T extends Comparable<? super T>>
    void quickSort(T[] a, int first, int last)
    {
        if (last - first + 1 < 5)
        {
            insertionSort(a, first, last);
        }
        else
        {
            // Create the partition: Smaller | Pivot | Larger
            int pivotIndex = partition(a, first, last);

            // Sort subarrays Smaller and Larger
            quickSort(a, first, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, last);
        } // end if
    } // end quickSort

    //  Partitions an array as part of quick sort into two subarrays
    //  called Smaller and Larger that are separated by a single
    //  entry called the pivot.
    //  Entries in Smaller are <= pivot and appear before the
    //  pivot in the array.
    //  Entries in Larger are >= pivot and appear after the
    //  pivot in the array.
    //  Parameters:
    //     a      An array of Comparable objects.
    //     first  The integer index of the first array entry;
    //            first >= 0 and < a.length.
    //     last   The integer index of the last array entry;
    //            last - first >= 3; last < a.length.
    //   Returns the index of the pivot.
    private static <T extends Comparable<? super T>>
    int partition(T[] a, int first, int last)
    {
        int mid = first + (last - first) / 2;
        sortFirstMiddleLast(a, first, mid, last);

        // Assertion: The pivot is a[mid]; a[first] <= pivot and
        // a[last] >= pivot, so do not compare these two array entries
        // with pivot.

        // Move pivot to next-to-last position in array
        swap(a, mid, last - 1);
        int pivotIndex = last - 1;
        T pivotValue = a[pivotIndex];

        // Determine subarrays Smaller = a[first..endSmaller]
        // and                 Larger  = a[endSmaller+1..last-1]
        // such that entries in Smaller are <= pivotValue and
        // entries in Larger are >= pivotValue; initially, these subarrays are empty

        int indexFromLeft = first + 1;
        int indexFromRight = last - 2;

        boolean done = false;
        while (!done)
        {
            // Starting at indexFromLeft, leave entries that are < pivotValue;
            // locate first entry that is >= pivotValue; you will find one,
            // since last entry is >= pivot
            while (a[indexFromLeft].compareTo(pivotValue) < 0)
                indexFromLeft++;
            // Assertion: a[indexFromLeft] >= pivotValue

            // Starting at indexFromRight, leave entries that are > pivot;
            // locate first entry that is <= pivot; you will find one,
            // since first entry is <= pivot

            while (a[indexFromRight].compareTo(pivotValue) > 0)
                indexFromRight--;
            // Assertion: a[indexFromRight] <= pivotValue

            if (indexFromLeft < indexFromRight)
            {
                swap(a, indexFromLeft, indexFromRight);
                indexFromLeft++;
                indexFromRight--;
            }
            else
                done = true;
        } // end while

        // Place pivotValue between the subarrays Smaller and Larger
        swap(a, pivotIndex, indexFromLeft);
        pivotIndex = indexFromLeft;

        // Assertion:
        //   Smaller = a[first..pivotIndex-1]
        //   Pivot = a[pivotIndex]
        //   Larger = a[pivotIndex+1..last]

        return pivotIndex;
    } // end partition

    //  Sorts the first, middle, and last entries of an array into ascending order.
    //  Parameters:
    //     a      An array of Comparable objects.
    //     first  The integer index of the first array entry;
    //            first >= 0 and < a.length.
    //     mid    The integer index of the middle array entry.
    //     last   The integer index of the last array entry;
    //            last - first >= 2, last < a.length.
    private static <T extends Comparable<? super T>>
    void sortFirstMiddleLast(T[] a, int first, int mid, int last)
    {
        order(a, first, mid); // Make a[first] <= a[mid]
        order(a, mid, last);  // Make a[mid] <= a[last]
        order(a, first, mid); // Make a[first] <= a[mid]
    } // end sortFirstMiddleLast

    // Orders two given array elements into ascending order
    // so that a[i] <= a[j].
    private static <T extends Comparable<? super T>>
    void order(T[] a, int i, int j)
    {
        if (a[i].compareTo(a[j]) > 0)
            swap(a, i, j);
    } // end order

    private static void swap(Object[] array, int i, int j)
    {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    } // end swap
}
