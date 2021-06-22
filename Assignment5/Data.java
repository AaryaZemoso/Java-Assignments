package Assignment5;

public class Data {
    int i;
    char ch;
    void print()
    {
        System.out.println(i + " " + ch);
    }

    // Explanation:-

    // This method will give a compile time error because the values which are inside the methods are
    // local variables and is a rule to initialize them.

    // It is different from instance variables which need not initial value as they will be assigned to 
    // default values as an object is instantiated. 

    // These values are initialized in constructor of the Class. If not provided the java compiler provides
    // a default constructor which initializes the values to default values.
    
    /*
        void printLocalVariable()
        {
            int x;
            char y;

            System.out.println(x + " " + y);
        }
    */

    // To make this method valid we just give them some initial value .
}
