package Week4.MoreGenerics.OrderedPair;

public class OrderedPair<T> implements Pairable<T>
{
    private T first, second;

    public OrderedPair(T firstItem, T secondItem) // NOTE: no <T> after constructor name
    {
        first = firstItem;
        second = secondItem;
    } // end constructor

    /** Returns the first object in this pair. */
    public T getFirst()
    {
        return first;
    } // end getFirst

    /** Returns the second object in this pair. */
    public T getSecond()
    {
        return second;
    } // end getSecond

    /** Returns a string representation of this pair. */
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    } // end toString

    /** Interchanges the objects in this pair. */
    public void changeOrder()
    {
        T temp = first;
        first = second;
        second = temp;
    } // changeOrder

    // Wildcards

    public static void displayPair(OrderedPair<?> pair)
    {
        System.out.println(pair);
    } // end displayPair

    public static void displayPairNumbers(OrderedPair<? extends Number> pair)
    {
        System.out.println(pair);
    }

    /*
    public static void displayPair(OrderedPair<Object> pair)
    would not work. Cannot be converted.
     */

} // end OrderedPair
