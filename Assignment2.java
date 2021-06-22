class CheckString 
/*
    This is Assignment-2.

    This program helps find if a given string has all the alphabets in it.
*/
{
    
    static boolean checkIfContainsAllAlphabets(String a)
    /*
        This method had the business logic.

        It creates a boolean array of 26 each element represents if the character exists are not.
        So we iterate over the given string and make the element true.

        After iterating the string, we then iterate over our boolean array to check if we have covered
        all the alphabets. If any of the element has false in its place then it represents that 
        the chacter of that index is not present in the given string. And hence we return false.
        Otherwise we return true.
    */
    {
        // Converting them to lowercase to make it easier for search
        a = a.toLowerCase();
        // Creating a boolean array.
        boolean[] check = new boolean[26];

        // Iterating over the string
        for(int i=0;i<a.length();i++)
            // Checking if the character in the current index position is alphabet or not.
            if(Character.isAlphabetic(a.charAt(i)))
                // If it is alphabet then make the particular boolean element true.
                check[a.charAt(i) - 'a'] = true;

        // Iterating over the boolean array
        for(int i=0;i<26;i++)
            // Checking if any of the element is not been present.
            if(!check[i])
                // If so, return false.
                return false;

        // Otherwise return true.
        return true;
    }

    public static void main(String[] args) {

        // Sample code.
        System.out.println(checkIfContainsAllAlphabets("abcdefghijklmnopqrstuvwxyz"));// Returns true
        System.out.println(checkIfContainsAllAlphabets("aarya devarla"));// Returns false
    
    }

}
