package Assignment7;

// Base class
class Rodent
{
    // Base class constructor
    Rodent()
    {
        // This prints everytime this class object is created
        // or any of the child class objects are created.
        System.out.println("In class Rodent");
    }

    // Base class methods
    void eat()
    {
        System.out.println("Rodent is eating");
    }
    void run()
    {
        System.out.println("Rodent is running");
    }
}
// Inheritance of Rodent
class Mouse extends Rodent
{
    // Child class Constructor
    Mouse()
    {
        // First calls super/base class constructor
        // Call Rodent() Constructor
        System.out.println("In class Mouse");
    }

    // Method overriding
    // Different Behaviours compared to Base class.
    void eat()
    {
        System.out.println("Mouse is eating");
    }
    void run()
    {
        System.out.println("Mouse is running");
    }
}

// Similarily for this class
class Gerbil extends Rodent
{
    Gerbil()
    {
        System.out.println("In class Gerbil");
    }

    void eat()
    {
        System.out.println("Gerbil is eating");
    }
    void run()
    {
        System.out.println("Gerbil is running");
    }
}

// Similarily for this class
class Hamster extends Rodent
{
    Hamster()
    {
        System.out.println("In class Hamster");
    }

    void eat()
    {
        System.out.println("Hamster is eating");
    }
    void run()
    {
        System.out.println("Hamster is running");
    }
}
class Main
{
    public static void main(String args[])
    {
        // Creating parent class reference and storing child objects.
        Rodent r[] = new Rodent[4];

        // Creating different objects.
        r[0] = new Rodent();
        r[1] = new Hamster();
        r[2] = new Gerbil();
        r[3] = new Mouse();

        // Calling the base class methods.
        for(Rodent rodent : r)
        {
            rodent.eat();
            rodent.run();
        }

        // We see that even though we are calling Rodent class methods
        // the child class behaviour is being printed.

        // This is an example of method overriding.
        // Also known as Runtime Polymorphism.

        // Which methods are to executed is decided on runtime, hence the name Runtime Polymorphism
    }
}