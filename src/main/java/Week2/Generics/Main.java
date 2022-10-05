package Week2.Generics;

public class Main {
    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        OrderedPair op = new OrderedPair(x, y);
        test(op);

        String a = "This";
        String b = "That";
        OrderedPair op2 = new OrderedPair(a, b);
        test(op2);

        double m = 1.38472;
        double n = 466.3835;
        OrderedPair op3 = new OrderedPair(m, n);
        test(op3);

    }

    public static void test(OrderedPair op) {
        System.out.println(op.toString());
        op.changeOrder();
        System.out.println(op.toString());
    }
}
