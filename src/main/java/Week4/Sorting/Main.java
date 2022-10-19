package Week4.Sorting;

public class Main {
    private static final Name[] items =
            {
                    new Name("Zeke",  "Clayton"), new Name("Bob",   "Clayton"), new Name("Rob",   "Smith"),
                    new Name("Ali",   "Babba"),   new Name("Jamie", "Perfect"), new Name("Jody",  "Perfect"),
                    new Name("Jim",   "Smith"),   new Name("John",  "Clayton"), new Name("Bill",  "Smith"),
                    new Name("Jamie", "Perfect"), new Name("Zeke",  "Clayton")
            };

    public static void main(String[] args)
    {
        //for (int count = 11; count > 0; count = count - 5)
        //{
        //    System.out.println(count + " items in array.");

            testSort(1, true, "selection sort", 1000);
            testSortName(1, true, "selection sort", 11);
            testSort(2, true, "insertion sort", 1000);
            testSort(3, true, "merge sort", 1000);
            testSort(4, true, "Shell sort", 1000);
            testSort(5, true, "quick sort", 1000);

        //} // end for
    }  // end main

    public static void testSort(int sort, boolean print, String name, int n)
    {
        System.out.println("\nTesting " + name + ":");

        Integer[] array = new Integer[1000];
        for(int i = 0; i < 1000; i++){
            array[i] = (int)(Math.random()*1000);
        }

        if (print)
        {
            System.out.println("Numbers array: ");
            System.out.println("\nBefore sort:");
            display(array, n);

        } // end if

        switch (sort)
        {
            case 1: SortArray.selectionSort(array, n); break;
            case 2: SortArray.insertionSort(array, n); break;
            case 3: SortArrayR.mergeSort(array, n); break;
            case 4: SortArray.shellSort(array, n); break;
            case 5: SortArrayR.quickSort(array, n); break;

        } // end switch

        if (print)
        {
            System.out.println("Numbers array: ");
            System.out.println("\nAfter sort:");
            display(array, n);

        } // end if

        check(array, n);
    } // end testSort

    public static void testSortName(int sort, boolean print, String name, int n)
    {
        System.out.println("\nTesting " + name + ":");

        Name[] nameArray = new Name[25];
        copyArray(nameArray, items);

        if (print)
        {
            System.out.println("Names Object array: ");
            System.out.println("\nBefore sort:");
            display(nameArray, n);
        } // end if

        switch (sort)
        {
            case 1: SortArray.selectionSort(nameArray, n); break;
            //case 2: SortArray.insertionSort(array, n); break;
            //case 3: SortArray.iterativeMergeSort(array, n); break;
            //case 4: SortArray.shellSort(array, n); break;
            //case 5: SortArray.betterShellSort(array, n); break;
            //case 6: SortArray.bubbleSort(array, n); break;
            //case 7: SortArray.betterBubbleSort(array, n); break;
            //case 8: SortArray.heapSort(array, n); break;
        } // end switch

        if (print)
        {
            System.out.println("Names Object array: ");
            System.out.println("\nAfter sort:");
            display(nameArray, n);
        } // end if

        check(nameArray, n);
    } // end testSort

    public static void display(Object[] array, int n)
    {
        for (int index = 0; index < n; index++)
            System.out.print(array[index] + ", ");
        System.out.println();
    } // end display

    public static void copyArray(Object[] copy, Object[] array)
    {
        for (int index = 0; index < array.length; index++)
            copy[index] = array[index];
    } // end copyArray

    public static <T extends Comparable<T>> void check(T[] array, int n)
    {
        if (isSorted(array, n))
            System.out.println("Method works.\n");
        else
            System.out.println("Method DOES NOT work!!!!!!!!!!!!!!!!!!!!!!!!\n");
    } // end check

    public static <T extends Comparable<T>> boolean isSorted(T[] array, int n)
    {
        boolean sorted = true;
        for (int index = 0; sorted && (index < n - 1); index++)
        {
            if (array[index].compareTo(array[index + 1]) > 0)
                sorted = false;
        } // end for

        return sorted;
    } // end isSorted
}
