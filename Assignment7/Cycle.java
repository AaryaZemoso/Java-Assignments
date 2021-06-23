package Assignment7;

// Base class
class Cycle{

}

// Child classes
class Unicycle extends Cycle{

    // Child class methods - NOT METHOD OVERRIDING
    void balance()
    {
        System.out.println("It has balance");
    }
}

class Bicycle extends Cycle{

    // Child class methods - NOT METHOD OVERRIDING
    void balance()
    {
        System.out.println("It has balance");
    }
}

class Tricycle extends Cycle{

}

class Main1 {
    public static void main(String[] args) {

        Cycle c[] = new Cycle[3];

        c[0] = new Unicycle();
        c[1] = new Bicycle();
        c[2] = new Tricycle();

        // This following piece of code will not work.
        // As there is no balance method for a Cycle class.
//        for(Cycle cyc : c)
//            cyc.balance();

        Unicycle uc = (Unicycle) c[0];
        Bicycle bc = (Bicycle) c[1];
        Tricycle tc = (Tricycle) c[2];

        // This is valid - as there is method available
        uc.balance();
        // This is also valid
        bc.balance();
        // This is not valid since the method is not available.
//        tc.balance();


    }
}