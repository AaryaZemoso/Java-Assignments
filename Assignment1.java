import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

class FindFiles {
    /*
        This is Assignment-1.

        This class tries to find all the files which match the regex.
        I have implemented in 3 different ways.
    */

    // Get the home directory location using System.getProperty
    static String homeDirectory = System.getProperty("user.home");

    static void usingCommandLine(String regex) throws IOException
    /*
        WARNING - USES ONLY LINUX GLOB/REGEX INSTEAD OF JAVA REGEX

        This method uses the shell commands to execute the query.
        Since I am working with linux, I've hard coded some the values.

        We use one of linux commands called 'find' which will search all the subdirectories from the 
        home folder which match the regex.
    */
    {

        // Runtime will get the instance of the bash.
        Runtime bash = Runtime.getRuntime();         
        
        // This will execute the query/command and gives Process as output.
        Process p = bash.exec("find /home/aarydb -name " + regex);

        // We use reader objects to read the output given by the above statement.
        // The outputs are in the form of absolute paths.
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    static void usingStreamLibraries(String regex) throws IOException
    /*
        This method uses Files object from java.nio packages.
        This method uses the concepts of stream.

    */
    {
        
        List<String> absolutePaths = Files.walk(Paths.get(homeDirectory))         // Files.walk goes through each subdirectory from the given path
                                        // Filtering out if the file is a file but not a directory
                                        .filter(Files::isRegularFile)
                                        // Filtering out the files which matches the regex expression
                                        .filter((x) -> x.getFileName().toString().matches(regex))
                                        // Mapping the file objects to strings which represent their absolute path.
                                        .map((x) -> x.toAbsolutePath().toString())
                                        // Collecting them in a form of List
                                        .collect(Collectors.toList());

        // Using stream api to print each paths in a newline
        absolutePaths.stream().forEach(System.out::println);
    }

    static void utilityForFileLibraries(File f, String regex, List<String> listOfPaths)
    /*
        This is a utility method for another method called 'usingFileLibraries'.
        This method recursively goes through each of the directories and checks if file name matches the regex.
    */
    {
        // Iterating over the different files and folders
        for(File file : f.listFiles())
            // If it is a directory then use recursion to imitate the same.
            if(file.isDirectory())
                utilityForFileLibraries(file, regex, listOfPaths);
            // If it is a file check if the filename matches the regex.
            else if(file.isFile())
                {
                    if(file.getName().matches(regex))
                        listOfPaths.add(file.getAbsolutePath());
                }
    }

    static void usingFileLibraries(String regex)
    {
        // Base code

        String home = homeDirectory;
        List<String> absolutePaths = new ArrayList<>();

        // Using the utility method for recursion
        utilityForFileLibraries(new File(home), regex, absolutePaths);

        // Printing the absolute paths using the streams.
        absolutePaths.stream().forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        while(true)
        {
            System.out.print("\nEnter regex : ");
            String regex = s.nextLine();
            if(regex.length() == 0)
                break;

            usingFileLibraries(regex);
        }

        s.close();
    }
}