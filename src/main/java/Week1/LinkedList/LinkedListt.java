package Week1.LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListt<P> {
    public static void main(String[] args) {
        LinkedList<Person> ll = new LinkedList<>();
        ll.add(new Person("Eric", 34, 60.1, 150.1));
        ll.add(new Person("Chris", 38, 60.1, 150.1));
        ll.add(1, new Person("Gino", 32, 60.1, 150.1));
        ListIterator<Person> personListIterator = ll.listIterator();

        while(personListIterator.hasNext()) {
            System.out.println(personListIterator.next().name);
        }
        System.out.println();
        while(personListIterator.hasPrevious()) {
            System.out.println(personListIterator.previous().getName());
        }

    }
}
