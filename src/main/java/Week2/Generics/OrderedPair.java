package Week2.Generics;

public class OrderedPair<T> implements PairableInterface<T> {
    private T first, second;

    public OrderedPair(T firstItem, T secondItem) {
        // No T after constructor name here
        first = firstItem;
        second = secondItem;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    // Returns string rep. of this pair
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    // Interchanges objects in the pair
    public void changeOrder()
    {
        T temp = first;
        first = second;
        second = temp;
    }
}
