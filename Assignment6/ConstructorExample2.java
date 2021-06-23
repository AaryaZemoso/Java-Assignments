package Assignment6;

class A{

    A(String a)
    {
        System.out.println(a);
    }

    public static void main(String[] args) {

        A a[] = new A[5];
        // We see that the constructor is not being called as
        // Array object is different from instance of the class.

        // We are not creating any instance of class instead we are
        // creating instance of array object which is different.

        // -------------------------------------------------------

        // If we now create and store references of objects we create.
        // We see that the print statement in constructor works.

        a[0] = new A("1");
        a[2] = new A("3");
        a[1] = new A("2");
        a[4] = new A("5");
        a[3] = new A("4");
    }
}


