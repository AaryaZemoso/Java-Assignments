import java.io.*;
import java.util.*;

class Ping 
/*
    This is Assignment 3.

    This program pings an ip address for 'n' times and get the median of the time taken to ping.
*/
{
    
    static double getMedianTimePing(String ip, int times) throws Exception
    /*
        This method leverages the use of the system shell to ping and get the time intervals in formatted string.
    */
    {
        // This command is used to ping the ip for 'times' times 
        // And it is filtered and formatted such that we only get the output of time intervals.
        String command = "ping " + ip + " -c" + times + " | grep \"time=\" | awk '{print $7}'| cut -d \"=\" -f2";

        // This gets the current runtime
        Runtime bash = Runtime.getRuntime();
        // Executes the command in shell
        Process process = bash.exec(new String[]{"/bin/sh", "-c", command});

        // Wait until the process is finished
        process.waitFor();

        // Creating list of time intevals
        List<Double> pingTime = new ArrayList<>();

        // Reading the output of the command just executed
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        
        while((line = reader.readLine()) != null)
            // Parses the value into double and stores in the 'pingTime' list.
            pingTime.add(Double.parseDouble(line));

        // Sorting the list
        Collections.sort(pingTime);

        int n = pingTime.size();

        // Returning the median based on the size of the list.
        // return n/2th position if odd
        // return avg(n/2, n+1/2) if even
        return (n & 1) == 1 ? pingTime.get(n/2) : (pingTime.get(n/2) + pingTime.get((n+1)/2))/2;
    }

    public static void main(String[] args) throws Exception{
        
        String ip = "8.8.8.8";
        int n = 5;
        
        System.out.println("Median Time = " + getMedianTimePing(ip, n));
    }
}
