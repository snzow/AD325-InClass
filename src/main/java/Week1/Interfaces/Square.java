package Week1.Interfaces;

import static java.lang.Math.pow;

/**
 * {@inheritDoc}
 */

public class Square implements Comparable<Square>, MeasurableInterface {

    private double side;

    public Square(double s) {side = s;}

    public void setSide(double newSide)
    {
        side = newSide;
    } // end setRadius

    public double getSide()
    {
        return side;
    } // end getRadius

    public double getPerimeter() {
        return 4*side;
    }

    public double getArea() {
        return pow(side, 2);
    }

    public int compareTo(Square other) {
        int result;
        if (this.equals(other))
            result = 0;
        else if (side < other.side)
            result = -1;
        else
            result = 1;

        return result;
    }

    public String toString()
    {
        return side + " ";
    } // end toString
}
