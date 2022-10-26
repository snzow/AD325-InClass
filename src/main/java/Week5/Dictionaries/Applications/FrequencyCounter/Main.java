package Week5.Dictionaries.Applications.FrequencyCounter;


import Week5.Dictionaries.Applications.TelephoneDirectory.TelephoneDirectory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        FrequencyCounter wordCounter = new FrequencyCounter();
        String resourceName = "src/Dictionaries/Applications/FrequencyCounter/Data.txt";

        try
        {
            InputStream is = TelephoneDirectory.class.getResourceAsStream(resourceName);

            Scanner data = new Scanner(new File(resourceName));
            wordCounter.readFile(data);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
        }

        System.out.println("Here is a list of the words that appear in the data file,\n" +
                "along with their frequencies of occurrence:");
        wordCounter.display();

        // Test Question 8, Chapter 19
        System.out.println("\nHere are the same words organized by their frequencies of occurrence:");
        wordCounter.display(1);
        wordCounter.display(2);
        wordCounter.display(3);
        wordCounter.display(4);
        wordCounter.display(5);
        wordCounter.display(6);

        System.out.println("Bye!");
    }  // end main
}
