package Week1.Recursion.ArrayProcessor;

public class Main {
    public static void main(String[] args) {
        int[] testScores = new int[]{96, 99, 88, 89, 90};

        ArrayProcessor ap = new ArrayProcessor();
        System.out.println(testScores.length);
        ap.displayArrayFirst(testScores, 0, testScores.length-1);
        System.out.println();

        ap.displayArrayLast(testScores, 0, testScores.length-1);
        System.out.println();

        ap.displayArraySplit(testScores, 0, testScores.length-1);
        System.out.println();
    }
}
