package Week1.LinkedList;

public class Person implements PersonInterface {
    String name;
    int age;
    double height;
    double weight;

    Person(String iname, int iage, double iheight, double iweight){
        name = iname;
        age = iage;
        height = iheight;
        weight = iweight;
    }

    public void setName(String name){
        name = name;
    }

    public String getName(){
        return name;
    }
}
