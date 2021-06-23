package Assignment7;

// Factory class
class CycleFactory{

    // Takes an argument to return different object based on it
    Cycle getCycle(String cycle)
    {
        // Using switch statement to check and return based on the argument.
        switch (cycle)
        {
            case "Unicycle" : return new Unicycle();
            case "Bicycle"  : return new Bicycle();
            case "Tricycle" : return new Tricycle();
            default:    return null;
        }
    }
}

class FactoryExample {
    public static void main(String[] args) {
        CycleFactory factory = new CycleFactory();

        // Since the return type is Cycle, we have to downcast it to Unicycle.
        Unicycle u = (Unicycle) factory.getCycle("Unicycle");
        // Otherwise we can use this based on requirement.
        Cycle b = factory.getCycle("Bicycle");
        Cycle t = factory.getCycle("Tricycle");

        // This is design pattern.

        // Making factory class speeds things up by leaving the
        // instantiation of objects by the factory itself.

        // Giving a parameter of what type of object is required,
        // it returns the specific type of object.

        // User can store the object and use it.
    }
}
