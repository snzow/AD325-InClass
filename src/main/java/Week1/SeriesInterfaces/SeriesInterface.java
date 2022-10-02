package Week1.SeriesInterfaces;

public interface SeriesInterface {

    public static final int MAX = 10;
    public static final String ERRORMSG = "Cannot go above value.";

    int getNext();
    int getPrev();

    default void printStuff(){
        System.out.println("Live from New York!");
        printEvenMoreStuff();
    }

    static void printMoreStuff() { System.out.println("Static method");}

    private void printEvenMoreStuff() { System.out.println("Private method");}

}
