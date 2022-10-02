package Week1.Recursion;

import Week1.Recursion.ArrayProcessor.ArrayProcessor;

public class Recursion {

    public static void main(String[] args) {
        countDown(5);

        int[] arr = {5, 8, 2, 4, 9};
        ArrayProcessor ap = new ArrayProcessor();
        ap.displayArrayFirst(arr, 0, arr.length-1);
        System.out.println("");
        ap.displayArrayLast(arr, 0, arr.length-1);
        System.out.println("");
        ap.displayArraySplit(arr, 0, arr.length-1);
    }

    public static void countDown(int integer) {
        System.out.println(integer);
        if (integer > 1) countDown(integer -1);
    }


}
