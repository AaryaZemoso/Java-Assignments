import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MatchPattern
/*
    This is Assignment 9.

    This program is about regular expression.
    This program uses Pattern and Matcher classes from java.util.regex package.

    This program is to check if the given text is starting with Capital letter and ends with a period(.).

 */
{
    public static void main(String[] args) {

        // Text to match it from
        String text = "Aarya Devarla";

        // Compiling the pattern with our regex.
        // Here, [A-Z] represents it can be any of the capital letter at that position. (In our case, first position)
        // Next, '.*' is divided into two:- '.' refers to any character and '*' refers to can repeat 0 or more times.
        // Finally, [.] refers to the period. Since, . and [.] have two different meanings in regex
        // Anything with [] will be taken literally.
        Pattern p = Pattern.compile("[A-Z].*[.]");
        Matcher m = p.matcher(text);

        // Finding a pattern in our text if it exists
        if(m.find())
            System.out.println("Follows The Regex");
        else
            System.out.println("Does not follow the regex");
    }
}
