package Week4.MoreGenerics;

public class Main {

    enum Color {RED, GREEN, BLUE, YELLOW}
    public static void main(String[] args) {


        Color c = Color.GREEN;
        System.out.println(c.compareTo(c.BLUE));
        System.out.println(c.compareTo(c.RED));
        System.out.println(c.compareTo(c.GREEN));


        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle(5.0);
        Circle c3 = new Circle(9.0);

        System.out.println("c1 and c2 are equal:");
        System.out.println("c1.equals(c2): " + c1.equals(c2));
        System.out.println("c1.compareTo(c2): " + c1.compareTo(c2));
        System.out.println();

        System.out.println("c1 and c3 are not equal:");
        System.out.println("c1.equals(c3): " + c1.equals(c3));
        System.out.println("c1 < c3: ");
        System.out.println("c1.compareTo(c3): " + c1.compareTo(c3));
        System.out.println();

        System.out.print("Calling aMethod(c3); result should be > 0 : ");
        aMethod(c3);

        Measurable c4 = new Circle(9.0);
        System.out.println("c4, whose radius is 9, has a circumference of " + c4.getPerimeter());
        System.out.println(" and an area of " + c4.getArea());

        System.out.println("\nDone.");

        Square<Integer> intSquare = new Square<>(5);
        //Square<String> stringSquare = new Square<>("23");


    }

    public static void aMethod(Comparable<Circle> item)
    {
        System.out.println(item.compareTo(new Circle(6.0)));
    } // end aMethod

}
