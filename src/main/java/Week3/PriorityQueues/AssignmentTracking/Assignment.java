package Week3.PriorityQueues.AssignmentTracking;

import java.sql.Date;

public class Assignment implements Comparable<Assignment>
{
    private String course;
    private String task;
    private Date date; // Due date

    public Assignment(String courseCode, String theTask, Date dueDate)
    {
        course = courseCode;
        task = theTask;
        date = dueDate;
    } // end constructor

    public String getCourseCode()
    {
        return course;
    } // end getCourseCode

    public String getTask()
    {
        return task;
    } // end getTask

    public Date getDueDate()
    {
        return date;
    } // end getDueDate

    public int compareTo(Assignment other)
    {
        return date.compareTo(other.date); // NB: Return the negative of this value if a maxheap is used for the priority queue
    } // end compareTo

    public String toString()
    {
        return date.toString() + " " + course + " " + task + "\n";
    } // end toString
} // end Assignment
