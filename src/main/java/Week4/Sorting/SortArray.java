package Week4.Sorting;

public class SortArray {
    // SELECTION SORT
    /** Sorts the first n objects in an array into ascending order.
     @param a  An array of Comparable objects.
     @param n  An integer > 0. */
    public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n) {
        for (int index = 0; index < n-1; index++) {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n-1);
            swap(a, index, indexOfNextSmallest);
            // Assertion: a[0] <= a[1] <= . . . <= a[index] <= all other a[i]
        }
    }

    // Finds the index of the smallest value in a portion of an array a.
    // Precondition: a.length > last >= first >= 0.
    // Returns the index of the smallest value among
    // a[first], a[first + 1], . . . , a[last].
    public static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
        T min = a[first];
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++) {
            if( a[index].compareTo(min) < 0) { // a[index] is smaller than min
                min = a[index];
                indexOfMin = index;
            }
            // Assertion: min is the smallest of a[first] through a[index].
        }
        return indexOfMin;

    }

    // INSERTION SORT
    public static <T extends Comparable<? super T>>
    void insertionSort(T[] a, int n)
    {
        insertionSort(a, 0, n - 1);
    } // end insertionSort

    public static <T extends Comparable<? super T>>
    void insertionSort(T[] a, int first, int last)
    {
        for (int unsorted = first + 1; unsorted <= last; unsorted++)
        {   // Assertion: a[first] <= a[first + 1] <= ... <= a[unsorted - 1]

            T firstUnsorted = a[unsorted];

            insertInOrder(firstUnsorted, a, first, unsorted - 1);
        } // end for
    } // end insertionSort

    private static <T extends Comparable<? super T>>
    void insertInOrder(T anEntry, T[] a, int begin, int end)
    {
        int index = end;

        while ((index >= begin) && (anEntry.compareTo(a[index]) < 0))
        {
            a[index + 1] = a[index]; // Make room
            index--;
        } // end for

        // Assertion: a[index + 1] is available
        a[index + 1] = anEntry;  // Insert
    } // end insertInOrder

    // -------------------------------------------------------------------------------

    // SHELL SORT
    public static <T extends Comparable<? super T>>
    void shellSort(T[] a, int n)
    {
        shellSort(a, 0, n - 1);
    } // end shellSort

    /** Sorts equally spaced elements of an array into ascending order.
     @param a      An array of Comparable objects.
     @param first  An integer >= 0 that is the index of the first
     array element to consider.
     @param last   An integer >= first and < a.length that is the
     index of the last array element to consider.
     */
    public static <T extends Comparable<? super T>>
    void shellSort(T[] a, int first, int last)
    {
        int n = last - first + 1; // Number of array entries
        int space = n / 2;
        while (space > 0)
        {
            for (int begin = first; begin < first + space; begin++)
            {
                incrementalInsertionSort(a, begin, last, space);
            } // end for
            space = space / 2;
        } // end while
    } // end shellSort

    private static <T extends Comparable<? super T>>
    void incrementalInsertionSort(T[] a, int first, int last, int space)
    {
        int unsorted, index;

        for (unsorted = first + space; unsorted <= last;
             unsorted = unsorted + space)
        {
            T nextToInsert = a[unsorted];
            index = unsorted - space;
            while ((index >= first) && (nextToInsert.compareTo(a[index]) < 0))
            {
                a[index + space] = a[index];
                index = index - space;
            } // end while

            a[index + space] = nextToInsert;
        } // end for
    } // end incrementalInsertionSort



    private static void swap(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } // end swap


}
