package Week4.MoreGenerics.OrderedPair;


import static Week4.MoreGenerics.OrderedPair.OrderedPair.displayPair;
import static Week4.MoreGenerics.OrderedPair.OrderedPair.displayPairNumbers;

public class Main {
    public static void main(String[] args) {
        OrderedPair<String> strPair = new OrderedPair<>("apple", "banana");
        OrderedPair<Integer> numPair = new OrderedPair<>(1, 2);

        displayPair(strPair);
        displayPair(numPair);

        // Bounded wildcards

        //displayPairNumbers(strPair);
        displayPairNumbers(numPair);
    }
}
