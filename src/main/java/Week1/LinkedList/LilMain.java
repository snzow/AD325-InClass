package Week1.LinkedList;

public class LilMain {
    public static void main(String[] args) {
        int[] vals = {8, 8, 3, 7, 2, 2, 2, 4, -1, -1, 9, 9, 9, 9, 9};
        LinkedIntList lil = new LinkedIntList(vals);

        System.out.println(lil.get(0));
        System.out.println(lil.size());
        System.out.println(lil.toStringShort());

        System.out.println(lil.toFormattedString());

        //lil.add(101);
        lil.add(15);
        System.out.println("Added 15 to the end");
        System.out.println(lil.toFormattedString());

        lil.add(3, 20);
        System.out.println("Added 20 to the 3rd index");
        System.out.println(lil.toFormattedString());

        lil.remove(4);
        System.out.println("Removed the 5th value (4rd index)");
        System.out.println(lil.toFormattedString());

    }
}
