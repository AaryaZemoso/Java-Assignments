import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class CountCharacters
/*
    This is assignment 11.

    This program is about file handling.
    TODO:- Read a file and count each character frequency. And write the output to a file.
    Use command line arguments.
 */
{

    public static void main(String[] args) throws Exception{

        // Check if the command line arguments are existing or not.
        if(args.length < 2)
        {
            System.out.println("Provide input filename and output filename");
            System.exit(0);
        }

//        System.out.println(Arrays.toString(args));

        // Store the input filename into a variable.
        String filename = args[0];
        // Store the output filename into another variable.
        String writeFilename = args[1];

        // Create a Hashmap storing the frequency of the characters.
        HashMap<Character, Integer> map = new HashMap<>();

        // Using the scanner class to read the file.
        Scanner s = new Scanner(new File(filename));
        // Iterating over the lines.
        while(s.hasNextLine())
            for(char c : s.nextLine().toCharArray())
                // Store the frequency into the map
                map.put(c, map.getOrDefault(c, 0) + 1);
        // Close the object
        s.close();

        // Create a file writing instance.
        FileWriter fw = new FileWriter(writeFilename);
        // Iterate over different character frequency in the map
        for(char key : map.keySet())
            // Write the output into a file.
            fw.write(key + " : " + map.get(key) + "\n");
        // Close the file object
        fw.close();

        // Optional :- throw a message to show the completed status.
        System.out.println("Output file written");
    }
}
