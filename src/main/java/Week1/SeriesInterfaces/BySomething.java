package Week1.SeriesInterfaces;

public abstract class BySomething {
    public static final int MAX = 10;
    public static final String ERRORMSG = "Cannot go above value.";

    int val;

    public abstract int getNext();

    public abstract int getPrev();
}
