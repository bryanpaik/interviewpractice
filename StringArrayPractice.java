/**
 * String Array Practice for interviews.
 * @author Bryan Paik
 */
public class StringArrayPractice{

    /**
     * IsUnique method: Implement an algorithm to determine if a string has all unique characters. 
     * What if you can't use additional data structures?
     * Hints #44, 117, 132
     * @param line is a String
     * @return boolean is true or false
     */
    public boolean isUnique(String line){
        // Create an array where each index corresponds to a character in ANSI (0 - 128)
        int[] uniqueArray = new int[128];

        charArrayCounter(line,uniqueArray);
        
        // loop through the array and look for any values above two
        for(int i: uniqueArray){
            if(i > 1)
                return false;
        }
        return true;
    }

    /**
     * Given two strings, write a method to decide if one is a permutation of the other.
     * @param lineA the first string.
     * @param lineB the second string.
     * @return boolean statement.
     */
    public boolean checkPerm(String lineA, String lineB){
        // will always be the same size

        // create an array with length of 128 (amount of letters in ANSI) 
        int[] charArray = new int[128];

        // iterate through each string's char array
        // convert char to int, find the corresponding index to the character, and add one
        charArrayCounterCase(lineA,charArray);
        charArrayCounterCase(lineB,charArray);

        // checks if there were two occurances of a character or none
        for (int i: charArray){
            if(i % 2 != 0){
                return false;
            }
        }

        return true;
    }

    /**
     * Converts each character to integer, find corresponding index in array, then adds one (this is an array of size 128).
     * @param line is a string
     * @param array is an array
     */
    public void charArrayCounter(String line, int[] array){
        // loop through each of the characters 
        for(Character c: line.toCharArray()){
            // convert the character into an integer
            int charNum = c;
            // find the corresponding index that matches the integer
            // add one to the index
            array[charNum] += 1; 
        }

    }

    /**
     * Converts each character to integer, find corresponding index in array, then adds one (this is an array of size 128).
     * Lower case only.
     * @param line is a string
     * @param array is an array
     */
    public void charArrayCounterCase(String line, int[] array){
        // loop through each of the characters 
        for(Character c: line.toCharArray()){
            // convert the character into an integer
            int charNum = Character.toLowerCase(c);
            // find the corresponding index that matches the integer
            // add one to the index
            array[charNum] += 1; 
        }

    }

    /**
     * Write a method to replace all spaces in string with '%20'.
     * String has sufficient space to hold additional characters
     * @param line String given
     * @param length True length of string
     */
    public void createUrl(Character[] line, int length){
        // this will serve as our second pointer for the real string
        int k = length - 1;

        // loop through the given string backwards, runtime O(N) where n is the length of the character array
        for (int i = line.length - 1; i > -1; i--){
        
            if(line[k].equals(' ')){
                line[i] = '0';
                line[i-1] = '2';
                line[i-2] = '%';
                i -= 2;
            }
            else
                line[i] = line[k];
            k--;
        }

    }

    /**
     * Check if the given string is a palindrome.
     * A palindrome is a word that is the same forward and backwards
     * @param line is the word we want to test
     * @return whether it is a palindrome
     */
    public boolean palindrome(String line){
        // create an integer array of size 128 where each index represents a character
        int[] list = new int[128];
        // count the occurances of each character (ignoring spaces)
        charArrayCounterCase(line,list);
        // ignore spaces
        list[32] = 0;
        // loop thorugh each of the values of the list 
        // (values should either be two, or one but one can only occur once (in case of odd length))
        boolean odd = false;
        for (int i: list){
            if(!odd && i == 1)
                odd = true;
            else if(i != 2 && i != 0) return false;
        }
        
        return true;
    }

    /**
     * Tests if the line is one edit away.
     * @param lineA is the first line
     * @param lineB is the second line
     * @return if it is one away or not
     */
    public boolean oneAway(String lineA, String lineB){
        //todo
        return true;
    }

    /**
     * Tests for replacement.
     * Hints #23, 97, 130
     */
    public int replacement(String lineA, String lineB){
        int counter = 0;
        // needs to be same length
        if(lineA.length != lineB.length) return false;

        // loop through compares each character, adds one to counter
        for(int i = 0; i < lineA.length(); i++){
            if(lineA.get(i) != lineB.get(i)) counter++;
        } 

        return counter;
    }

    /**
     * Insertion and deletion test for one away.
     * @param lineA
     * @param lineB
     * @return
     */
    public int insertDeletionTest(String lineA, String lineB){
        //todo
        int counter = 0;
        Character[] largeLine = null;
        Character[] smallLine = null;

        //length of strings cannot differ by more than two
        
        // puts variable into larger and smaller
        if(lineA.length() >  lineB.length()){
            largeLine = lineA.toCharArray();
            smallLine = lineB.toCharArray();
        }
        // if the size of the lines are more than one they cannot be the same
        else{
            largeLine = lineB.toCharArray();
            smallLine = lineA;
        }

        int k = 0;
        // loop through the large line
        for(int i = 0; i < largeLine.length; i++){
            
        }   
        


        return counter;
    }

    /**
     * String compression.
     * String 'aabccccaaa' -> 'a2b1c5a3'
     * @param line that is being passed in
     */
    public String compressString(String line){
        StringBuilder newString = new StringBuilder();
        Character newChar = ' ';
        int counter = 0;
        // loop through string
        for(Character c: line.toCharArray()){
            // check if next letter is not the same
            if(!newChar.equals(c)){
                // record the letter
                // if different reset counter to zero and record the new letter
                newString.append(newChar);
                if(newChar != ' '){
                    newString.append(counter);                    
                }
                
                newChar = c;
                counter = 1;
            }
            else{
                // if same add to counter
                counter++;
            }
        }
        line = newString.toString();
        return line;
    }


    public void 
    /**
     * Sets the row and column to zero if one of the elements is zero.
     * @param matrix is the elements
     */
    public void setToZero(int[][] matrix){
        //todo
    }

    /**
     * Main tester for all the methods.
     */
    public static void main(String [] args){
        StringArrayPractice run = new StringArrayPractice();

        // isUnique method
        System.out.println("\nisUnique Method:");
        System.out.println(run.isUnique("unique"));
        System.out.println(run.isUnique("not ton"));

        // checkPermutations method
        System.out.println("\nCheck Permutations:");
        System.out.println(run.checkPerm("Racecar", "rcaecar"));
        System.out.println(run.checkPerm("billy", "Billy"));
        System.out.println(run.checkPerm("aklkldjfa","voaijre"));  
        System.out.println(run.checkPerm("yep","pey"));
        
        // create url method
        System.out.println("\nCreate URL");
        Character[] line = new Character[]{'m','r',' ','j','o','h','n',' ','s','m','i','t','h',' ',' ',' ',' '};
        run.createUrl(line, 13);

        // palindrome method
        System.out.println("\nPalindrome method");
        System.out.println(run.palindrome("Race car"));

        // one away method.... todo

        // compressString method
        String lineComp = "aaabbbbbcccccddddd";
        System.out.println(run.compressString(lineComp));
    }
}