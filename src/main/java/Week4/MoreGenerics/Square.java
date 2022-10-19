package Week4.MoreGenerics;

public class Square<T extends Number> {
    private T side;

    public Square(T initialSide)
    {
        side = initialSide;
    } // end constructor

    public T getSide()
    {
        return side;
    } // end getSide
} // end Square

