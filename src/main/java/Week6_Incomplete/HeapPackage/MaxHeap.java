package Week6_Incomplete.HeapPackage;

import java.util.Arrays;

public final class MaxHeap<T extends Comparable<? super T>>
        implements MaxHeapInterface<T>
{
    private T[] heap;      // Array of heap entries; ignore heap[0]
    private int lastIndex; // Index of last entry and number of entries
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 5; // NB: Changed to 5 from 25 for testing convenience
    private static final int MAX_CAPACITY = 10000;

    public MaxHeap()
    {
        this(DEFAULT_CAPACITY); // Call next constructor
    } // end default constructor

    public MaxHeap(int initialCapacity)
    {
        // NOTE: This code deviates from the book somewhat in that checkCapacity throws an exception
        //       if initialCapacity is either too small or too large.
        integrityOK = false;
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[])new Comparable[initialCapacity + 1]; // First array element is not used
        heap = tempHeap;
        lastIndex = 0;
        integrityOK = true;
    } // end constructor

    public MaxHeap(T[] entries)
    {
        this(entries.length); // Call other constructor
        // Assertion: integrityOK = true
        lastIndex = entries.length;

        // Copy given array to data field
        for (int index = 1; index <= lastIndex; index++)
            heap[index] = entries[index - 1];

        // Create heap
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
            reheap(rootIndex);
    } // end constructor

    /****************
     ADD METHOD
     ***************/

    public void add(T newEntry)
    {

    } // end add

    public T removeMax()
    {
        checkIntegrity();             // Ensure initialization of data fields
        T root = null;

        if (!isEmpty())
        {
            root = heap[1];            // Return value
            heap[1] = heap[lastIndex]; // Form a semiheap
            lastIndex--;               // Decrease size
            reheap(1);                 // Transform to a heap
        } // end if

        return root;
    } // end removeMax

    public T getMax()
    {
        checkIntegrity();
        T root = null;

        if (!isEmpty())
            root = heap[1];

        return root;
    } // end getMax

    public boolean isEmpty()
    {
        return lastIndex < 1;
    } // end isEmpty

    public int getSize()
    {
        return lastIndex;
    } // end getSize

    public void clear()
    {
        checkIntegrity();
        while (lastIndex > -1)
        {
            heap[lastIndex] = null;
            lastIndex--;
        } // end while

        lastIndex = 0;
    } // end clear

    /****************
     REHEAP METHOD
     ***************/

    // Precondition: checkIntegrity has been called.
    private void reheap(int rootIndex)
    {

    } // end reheap

    // Doubles the capacity of the array heap if it is full.
    // Precondition: checkIntegrity has been called.
    private void ensureCapacity()
    {
        int numberOfEntries = lastIndex;
        int capacity = heap.length - 1;
        if (numberOfEntries >= capacity)
        {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity); // Is capacity too big?
            heap = Arrays.copyOf(heap, newCapacity + 1);
        } // end if
    } // end ensureCapacity

    // Throws an exception if this object is corrupt.
    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException ("MaxHeap object is corrupt.");
    } // end checkIntegrity

    // Throws an exception if the client requests a capacity
    // that is either too small or too large.
    private void checkCapacity(int capacity)
    {
        if (capacity < DEFAULT_CAPACITY)
            throw new IllegalStateException("Attempt to create a heap " +
                    "whose capacity is smaller than " +
                    DEFAULT_CAPACITY);
        else if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a heap " +
                    "whose capacity is larger than " +
                    MAX_CAPACITY);
    } // end checkCapacity

    public void display(){
        for (T element: heap) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

} // end MaxHeap
