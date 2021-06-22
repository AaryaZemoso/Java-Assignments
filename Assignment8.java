class Main
/*
    This is Assignment 8.

    This program deals with Error Handling.

 */
{
    public static void main(String[] args) {

        /*
            Here, we can check if the Exceptions are being throws by calling the methods.
            We have to reorder to check to see if the Exception is actually being thrown.

            Put the Exception you want to see be thrown on top.
         */
        try{
            ThrowExceptionClass.nullException();
            ThrowExceptionClass.methodC();
            ThrowExceptionClass.methodB();
            ThrowExceptionClass.methodA();
        }

        /*
            This block catches the Exceptions of class ExceptionA, ExceptionB, ExceptionC
            And prints the message.
         */
        catch(ExceptionA | ExceptionB | ExceptionC exception)
        {
            System.out.println(exception.toString());
        }

        /*
            This block always prints/executes even if there is a catch block which handles the specific exception or not.
         */
        finally {
            System.out.println("In Finally Block");
        }
    }
}

/*
    Creating 3 Classes names ExceptionA, ExceptionB, ExceptionC

    These 3 Classes extends Exception Class.
    Hence, these 3 classes can be used for throwing the exception object.
 */
class ExceptionA extends Exception {
    ExceptionA(String a)
    {
        super(a);
    }
}
class ExceptionB extends Exception {
    ExceptionB(String a)
    {
        super(a);
    }
}
class ExceptionC extends Exception {
    ExceptionC(String a)
    {
        super(a);
    }
}

/*
    This is a dummy class.

    This class throws Exceptions of different type based on what method is called.
    All the methods are static, so need not create any objects.

 */
class ThrowExceptionClass{
    static void methodA() throws ExceptionA
    {
        throw new ExceptionA("This is Exception A");
    }
    static void methodB() throws ExceptionB
    {
        throw new ExceptionB("This is Exception B");
    }
    static void methodC() throws ExceptionC
    {
        throw new ExceptionC("This is Exception C");
    }
    static void nullException() throws NullPointerException
    {
        throw new NumberFormatException("Null pointer");
    }
}
