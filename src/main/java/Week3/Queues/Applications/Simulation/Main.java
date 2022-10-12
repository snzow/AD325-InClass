package Week3.Queues.Applications.Simulation;


import Week3.Queues.EmptyQueueException;

public class Main {
    public static void main(String[] args) throws EmptyQueueException {
        WaitLine customerLine = new WaitLine();
        customerLine.simulate(20, 0.5, 5);
        customerLine.displayResults();

        System.out.println("\n\nDone.");
    }  // end main
}
