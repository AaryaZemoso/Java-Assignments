package Assignment7;

class A{
    class B{
        int x;
        B(int x)
        {
            this.x=x;
        }
    }
}
class C{

    // This is not possible since B is not accessible outside A
    // We can fix this by making the inner class B static
    class D extends A.B{
        D()
        {
            super(0);
        }
    }
}

class Main2{
    public static void main (String[] args) {
        C.D x=new C().new D();
    }
}