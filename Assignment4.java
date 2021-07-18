import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class KYC
/*
    This is Assignment 4.
*/
{

    static String findRange(String signupDateString, String currDateString)
    /*
        Using date operations to solve the problem.
    */
    {
        // Formatter to use format/parse a given date of this pattern
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Parsing the date inputs into date objects.
        LocalDate signupDate = LocalDate.parse(signupDateString, format);
        LocalDate currDate = LocalDate.parse(currDateString, format);

        // Boundary conditions if the currdate is before the signupdate.
        if(currDate.isBefore(signupDate))
            return "No range";

        // Making two variables which are +-30 days from anniversary of signupdate
        LocalDate minSignupDate = LocalDate.of(currDate.getYear(), signupDate.getMonthValue(), signupDate.getDayOfMonth()).minusDays(30);
        LocalDate maxSignupDate = LocalDate.of(currDate.getYear(), signupDate.getMonthValue(), signupDate.getDayOfMonth()).plusDays(30);

        // Check if the currdate is within the range
        if(currDate.isBefore(maxSignupDate))
            return minSignupDate.format(format) + " " + currDate.format(format);

        else
            return minSignupDate.format(format) + " " + maxSignupDate.format(format);
    }

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        String result = "";

        int t = Integer.parseInt(s.nextLine());
        while(t-- > 0)
            {
                String[] input = s.nextLine().split(" ");
                result += findRange(input[0], input[1]) + "\n";
            }

        s.close();

        System.out.println();
        System.out.println(result);

    }
}
