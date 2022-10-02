package Week1.SeriesInterfaces;

public final class ByTwos  extends BySomething implements SeriesInterface {
    int val;
    int increment;

    ByTwos() {
        val = 0;
        increment = 2;
    }
    public int getNext() {
        if(val >= BySomething.MAX){
            System.out.println(BySomething.ERRORMSG);
        }
        val += 2;
        return val;
    }

    public int getPrev() {
        val -= 2;
        return val;
    }




}
