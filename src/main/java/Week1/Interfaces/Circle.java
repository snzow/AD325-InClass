package Week1.Interfaces;
/**
 * {@inheritDoc}
 */

public class Circle implements Comparable<Circle>, MeasurableInterface
{
   private double radius;

   /**
    * Default constructor of Circle class.
    */
   public Circle()
   {
   } // end default constructor

   /**
    * Constructor for the Circle class.
    * @param newRadius  Double recieved that is the radius of the circle being created.
    */
   public Circle(double newRadius)
   {
      assert radius != 0: "Circle cannot be 0 radius";
      radius = newRadius;
   } // end constructor

   /**
    * This method is used to return the circumference of the circle.
    * @return 2 times pi * the radius of the circle.
    */
   public double getCircumference()
   {
      return 2.0 * Math.PI * radius;
   } // end getCircumference

   public double getPerimeter() // Measurable interface
   {
      return getCircumference();
   } // end getPerimeter

   public double getArea()      // Measurable interface
   {
      return Math.PI * radius * radius;
   } // end getArea

   /**
    * This method is used to return the radius of the circle as a string for printing.
    * @return the radius of the circle as a string for printing
    */
   public String toString()
   {
      return radius + " ";
   } // end toString

   /**
    * This method is used to compare two Circle objects. Uses the equal function.
    * @return returns a boolean of if the two objects are the same.
    */
   public int compareTo(Circle other)
   {
      int result;
      if (this.equals(other))
         result = 0;
      else if (radius < other.radius)
         result = -1;
      else 
         result = 1;

      return result;
   } // compareTo

   /**
    * This method is used to compare two Circle objects by comparing their radi.
    * @return returns a boolean of if the two objects have the same radius.
    */
   public boolean equals(Object other)
   {
      boolean result;
      if ((other == null) || (getClass() != other.getClass()))
         result = false;
      else
      {
         Circle otherCircle = (Circle)other;
         result = (radius == otherCircle.radius);
      } // end if

      return result;
   } // end equals
} // end Circle
