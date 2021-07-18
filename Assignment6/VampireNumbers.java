package Assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class VampireNumbers
/*

    This is Assignment 6.

    This program is to find the first 100 vampire numbers.
 */
{

    static boolean isVampire(int a)
    /*
        This method tells us if we the given number is a vampire number.
     */
    {
        // The number should be even or else it violates the condition to be a vampire number.
        if((String.valueOf(a).length() & 1) == 1)
            return false;

        // Finding all permutations of n / 2 length and storing them in an arraylist 'Permutations'.
        ArrayList<String> permutations = new ArrayList<>();
        permute(String.valueOf(a), "", String.valueOf(a).length()/2, permutations);

//        System.out.println("Checking for " + a);

        // Iterating over the permuted values
        // to see if the product of any of the two permuted value gives the original value.
        for(String i : permutations)
            for(String j : permutations)
            {
                // If two of the fangs have trailing 0's it violates the condition to be a vampire number.
                if(i.charAt(i.length() - 1) == '0' && j.charAt(j.length() - 1) == '0')
                    continue;   // Hence, we skip to next permuted value.

                // Parsing into Integers
                int x = Integer.parseInt(i);
                int y = Integer.parseInt(j);

                if(x * y != a)
                    continue;

                // Getting the digits of product and individual numbers
                char prodArray[] = String.valueOf(x * y).toCharArray();
                char concatArray[] = (i + j).toCharArray();

                // Sorting the digits
                Arrays.sort(prodArray);
                Arrays.sort(concatArray);

                // If both the given arrays are same, then it is a vampire number.
                if(Arrays.equals(prodArray, concatArray))
                {
                    System.out.println(x + " x " + y + " = " + a);
                    return true;
                }

            }

        return false;
    }

    static void permute(String s , String answer, int length, List<String> list)
    /*
        This is a utility method to find all the permutations of a given String
        of length.
     */
    {
        // Recursion base condition
        // If the factor accumulated to desire length, then add it to the list
        // and return.
        if (answer.length() == length)
        {
            list.add(answer);
            return;
        }

        // Iterate over each character and recurse without the current character.
        for(int i = 0 ;i < s.length(); i++)
        {
            char ch = s.charAt(i);

            // Create Left substring and right substring.
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);

            String rest = left_substr + right_substr;

            // Recurse
            permute(rest, answer + ch, length, list);
        }
    }

    public static void main(String[] args) {

        int count = 0;

        int i = 11;

        // Takes 10 minutes to run
        while(count < 100)
        {
            if(isVampire(i))
            {
//                System.out.println(i);
                count++;
            }

            i++;
        }
    }
}
