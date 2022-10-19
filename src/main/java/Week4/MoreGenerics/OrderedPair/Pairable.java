package Week4.MoreGenerics.OrderedPair;

public interface Pairable<T>
{
    public T getFirst();
    public T getSecond();
    public void changeOrder();
} // end Pairable
