package Assignment6;

class Color{

    String hexValue;

    // Default Constructor
    Color()
    {
        // Calling the parameterized constructor
        this("#FFFFFF");
    }

    // Parametertized Constructor
    Color(String hexValue)
    {
        this.hexValue = hexValue;
    }

    public static void main(String[] args) {

        Color c = new Color();
        System.out.println(c.hexValue);

        Color d = new Color("#000000");
        System.out.println(d.hexValue);
    }
}
