package Week1.SeriesInterfaces;

public final class ByThrees extends BySomething implements SeriesInterface {
    int val;

    ByThrees() {
        val = 0;
    }
    public int getNext() {
        val += 3;
        return val;
    }

    public int getPrev() {
        val -= 3;
        return val;
    }
}
