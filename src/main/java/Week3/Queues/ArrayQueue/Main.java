package Week3.Queues.ArrayQueue;


import Week3.Queues.EmptyQueueException;
import Week3.Queues.QueueInterface;

public class Main {
    public static void main(String[] args) throws EmptyQueueException {
        testQueueOperations();
        System.out.println("\n\nDone.");
    }  // end main

    public static void testQueueOperations() throws EmptyQueueException {
        System.out.println("Create a queue: ");
        QueueInterface<String> myQueue = new ArrayQueue<>();
        System.out.println("\n\nisEmpty() returns " + myQueue.isEmpty() + "\n");

        System.out.println("Add to queue to get\n" +
                "Joe Jess Jim Jill Jane Jerry\n");
        myQueue.enqueue("Joe");
        myQueue.enqueue("Jess");
        myQueue.enqueue("Jim");
        myQueue.enqueue("Jill");
        myQueue.enqueue("Jane");
        myQueue.enqueue("Jerry");

        myQueue.display();

        System.out.println("\nisEmpty() returns " + myQueue.isEmpty() + "\n");

        System.out.println("\n\nTesting getFront and dequeue:\n");
        while (!myQueue.isEmpty())
        {
            String front = myQueue.getFront();
            System.out.println(front + " is at the front of the queue.");

            front = myQueue.dequeue();
            System.out.println(front + " is removed from the front of the queue.\n");
        } // end while

        System.out.print("\nThe queue should be empty: ");
        System.out.println("isEmpty() returns " + myQueue.isEmpty() + "\n\n");

        System.out.println("Add to queue to get\n" +
                "Joe Jess Jim\n");
        myQueue.enqueue("Joe");
        myQueue.enqueue("Jess");
        myQueue.enqueue("Jim");

        System.out.println("\nTesting clear:\n");
        myQueue.clear();

        System.out.println("\nisEmpty() returns " + myQueue.isEmpty() + "\n\n");

        System.out.println("Add to queue to get\n" +
                "Joe Jess Jim\n");
        myQueue.enqueue("Joe");
        myQueue.enqueue("Jess");
        myQueue.enqueue("Jim");

        while (!myQueue.isEmpty())
        {
            String front = myQueue.getFront();
            System.out.println(front + " is at the front of the queue.");

            front = myQueue.dequeue();
            System.out.println(front + " is removed from the front of the queue.\n");
        } // end while

        System.out.print("\n\nThe queue should be empty: ");
        System.out.println("isEmpty() returns " + myQueue.isEmpty() + "\n");

        System.out.println("The next calls will throw an exception." + "\n");
        System.out.println("myQueue.getFront() returns " +  myQueue.getFront());
        System.out.println("myQueue.dequeue() returns " +  myQueue.dequeue() + "\n");
    } // end testQueueOperations
}
