package Assignment7;

// Interfaces
interface InterfaceA{
    void methodA1();
    void methodA2();
}

interface InterfaceB{
    void methodB1();
    void methodB2();
}

interface InterfaceC{
    void methodC1();
    void methodC2();
}

interface InterfaceABC extends InterfaceA, InterfaceB, InterfaceC{
    void methodABC();
}

// Concrete class
class XYZ implements InterfaceABC{

    @Override
    public void methodA1() {
        System.out.println("In method methodA1");
    }

    @Override
    public void methodA2() {
        System.out.println("In method methodA2");
    }

    @Override
    public void methodB1() {
        System.out.println("In method methodB1");
    }

    @Override
    public void methodB2() {
        System.out.println("In method methodB2");
    }

    @Override
    public void methodC1() {
        System.out.println("In method methodC1");
    }

    @Override
    public void methodC2() {
        System.out.println("In method methodC2");
    }

    @Override
    public void methodABC() {
        System.out.println("In method methodABC");
    }

    // This takes the objects which implement InterfaceA as an object
    static void showMethodA(InterfaceA a){
        a.methodA1();
        a.methodA2();
    }

    // Similarly this takes objects which implement InterfaceB
    static void showMethodB(InterfaceB b)
    {
        b.methodB1();
        b.methodB2();
    }

    // Similarly this takes objects which implement InterfaceC
    static void showMethodC(InterfaceC c)
    {
        c.methodC1();
        c.methodC2();
    }

    // Similarly this takes objects which implement InterfaceABC
    static void showMethodABC(InterfaceABC abc)
    {
        abc.methodABC();
    }
}

class Main4{
    public static void main(String[] args) {

        XYZ xyz = new XYZ();

        // Since xyz implements interface 'InterfaceABC' which implement 'InterfaceA'
        // So this can be passed as an argument for the 'showMethodA'
        XYZ.showMethodA(xyz);

        // Similarly for other methods also
        XYZ.showMethodB(xyz);
        XYZ.showMethodC(xyz);
        XYZ.showMethodABC(xyz);

        // This shows that Parent class reference can have child class objects.
        // And these since using the interfaces we restrict the use of methods
        // by making the object use only methods specific to that interface alone.

    }
}