package Week1;

import java.util.ArrayList;
import java.util.List;

public class ListsArrayLists {
    public static void main(String[] args) {

        // Generalized form of list
        List colors = new ArrayList();
        colors.add("blue");
        colors.add("purple");
        colors.add(1);
        colors.add(new Object());

        // Typed form of list
        List<String> shapes = new ArrayList<>();
        shapes.add("circle");

        System.out.println(colors);
        System.out.println(shapes);
        System.out.println(shapes.size());
        System.out.println(shapes.contains("square"));

        // loop through and print
        for (Object color : colors) {
            System.out.println(color);
        }

        colors.forEach(System.out::println);

        for (int i = 0; i < colors.size(); i++){
            System.out.println(colors.get(i));
        }
    }
}
