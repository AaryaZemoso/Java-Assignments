package Assignment5;

public class Singleton {

    String randomString;

    // Explanation :- 
    /*
        Static methods cannot access instance variable or non-static methods.

        As static methods can be used without creating an instance of object it is understood that
        it cant access or use the instance variable or non-static methods.

        Since, it is a static method, the keyword 'this' has no significance as there is no object
        to refer it to.

        Hence this method is invalid.
    */
    /*
        static Singleton init(String initString)
        {
            this.randomString = initString;
            return this;
        }
    */
    /*
        We can solve this problem by making this method non-static or passing the object as a parameter.
        These 2 ways are workarounds to make this method work.
    */

    void print()
    {
        System.out.println(randomString);
    }
}
