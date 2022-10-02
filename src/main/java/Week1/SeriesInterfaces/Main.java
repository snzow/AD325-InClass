package Week1.SeriesInterfaces;

import static Week1.SeriesInterfaces.SeriesInterface.printMoreStuff;

public class Main {
    public static void main(String[] args) {

        goodUseCaseDT();
        badUseCaseDT();
        fixedBadUseCaseDT();

    }

    public static void goodUseCaseDT(){
        System.out.println("Series max is " + SeriesInterface.MAX);

        SeriesInterface byInterface;

        byInterface = new ByTwos();
        for (int i= 1; i < 6; i++)
        {
            System.out.println(byInterface.getNext());
        }

        // define the interface as a data type
        // reuse the same variable, different operation and procedure
        byInterface = new ByThrees();
        for (int i= 1; i < 6; i++)
        {
            // from interface as data type
            System.out.println("By Threes: " + byInterface.getPrev());
        }

        byInterface.printStuff();

        // Static method from interface
        printMoreStuff();

    }

    public static void badUseCaseDT(){
        System.out.println("Series max is " + SeriesInterface.MAX);

        SeriesInterface byInterface;

        byInterface = new ByTwos();
        for (int i= 1; i < 6; i++)
        {
            System.out.println(byInterface.getNext());
        }

        // define the interface as a data type
        byInterface = new ByThrees();
        for (int i= 1; i < 6; i++)
        {
            System.out.println("By Twos: " + byInterface.getNext());

            // from interface as data type
            System.out.println("By Threes: " + byInterface.getPrev());
        }

        byInterface.printStuff();

        // Static method from interface
        printMoreStuff();
    }

    private static void fixedBadUseCaseDT() {
        System.out.println("Series max is " + SeriesInterface.MAX);

        SeriesInterface byInterface;

        ByTwos byTwos = new ByTwos();
        for (int i= 1; i < 6; i++)
        {
            System.out.println(byTwos.getNext());
        }

        // define the interface as a data type
        byInterface = new ByThrees();
        for (int i= 1; i < 6; i++)
        {
            System.out.println("By Twos: " + byTwos.getNext());

            // from interface as data type
            System.out.println("By Threes: " + byInterface.getPrev());
        }

        byInterface.printStuff();

        // Static method from interface
        printMoreStuff();
    }
}
