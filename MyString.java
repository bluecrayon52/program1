/*
 * Nathaniel Clay Arnold 
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */

import java.util.Arrays; // used in equals method 

public class MyString {

    private char[] strChars;
    private int currLength;

// Empty Constructor 
    public MyString() {
        strChars = null;
        currLength = 0;
    }

// Constructor initialize char array to characters in String
    public MyString(String str) {
        currLength = str.length();
        strChars = new char[currLength];
         
        for (int i = 0; i < currLength; i++) {
            strChars[i] = str.charAt(i);
        }
        ensureCapacity();
    }

 // Copy Constructor 
    public MyString(MyString str) {
        currLength = str.currLength;
        strChars = new char[currLength]; 
         
        for (int i = 0; i < currLength; i++) {
            strChars[i] = str.strChars[i];
            
        }
       ensureCapacity();  
    }

 // Length Method, returns length of string in array, not last array index  
    public int length() {
        return currLength;
    }

 // Allocate additional memory for the string 
    private void ensureCapacity() {
        
            // increase size of array 
            char[] cap = new char[this.currLength + 1];
            
            // pass values to temp array 
            for(int i = 0; i < currLength; i++){
                cap[i] = strChars[i]; 
            }
            // new instance of strChars
            strChars = new char[this.currLength + 1];
            
            //pass values back 
            for(int a = 0; a < currLength; a++){
               strChars[a] = cap[a];        
            }
             
        }

    

 // return a string representation of the MyString object 
    public String toString() {
        
        if(strChars == null){ // for empty MyString 
        String stringRep = new String();  
        return stringRep; 
        }
       
        // copy array to trim null for printout 
        char[] copy = new char[currLength]; 
        
        for(int i = 0; strChars[i] != '\u0000'; i++){
               copy[i] = strChars[i];
            }
        String stringRep = new String(copy);
        return stringRep;
    }
    
    /* concat method takes a MyString parameter, returns MyString object
     that is a concatination of of calling object and parameter 
     */

    public MyString concat(MyString str) {
        int comboLength = str.currLength + currLength;
        
        // set length of new array 
        char[] copyArr = new char[comboLength]; 
        
        //place first (calling) string into array
        for (int i = 0; i < currLength; i++) {  
            copyArr[i] = strChars[i]; 
        }
        // place second (perameter) string into array
        for (int i = currLength, a = 0; i < comboLength; i++, a++) {
            copyArr[i] = str.strChars[a];  
        }
        // turn array into string
        String stringRep = new String(copyArr);  
        
        // pass string to MyString constructor
        MyString Concat = new MyString(stringRep); 

        return Concat;
    }
    
    /* overloaded concat method takes a String parameter and concatinates it 
    with the calling MyString object, returning a new MyString object. 
    */
    public MyString concat(String str) {
        int strLength = str.length();
        int comboLength = strLength + currLength;
        
        // set length of new array 
        char[] copyArr = new char[comboLength];
        
        // place first (calling) string into array 
        for (int i = 0; i < currLength; i++) {
            copyArr[i] = strChars[i];
        }
        
        //place second (peramter) string into array 
        for (int i = currLength, a = 0; i < comboLength; i++, a++) {
            copyArr[i] = str.charAt(a);
        }
        
        // turn array into string 
        String stringRep = new String(copyArr);
        
        //pass string to MyString constructor 
        MyString Concat = new MyString(stringRep);

        return Concat;

        
    }

    /*  .equals method takes MyString parameter, returns true if 
     this MyString and the parameter are the same 
     */
    public boolean equals(MyString str) {

        boolean equal = Arrays.equals(strChars, str.strChars);

        return equal;
    }

    // or an alternative to importing java.util.Array for .equals method 
    public boolean equalTo(MyString str) {
        
        // check for length equality 
        if (str.currLength != currLength) {
            return false;
            
        // traverse arrays for inequalities 
        } else if (str.currLength == currLength) {
            for (int i = 0; i < currLength; i++) {
                if (strChars[i] != str.strChars[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /*  .compareTo method, takes MyString parameter, returns as follows:
     0 if the parameter and this MyString are same 
     neg int if this MyString is alphabetically before the perameter 
     pos int if this MyString is alph. after perameter
     */
    public int compareTo(MyString str) {
        
        // determine shortest string for inbounds traversal indexing 
        int length_diff = currLength - str.currLength;
        int charDiff = 0;
        
        // calling object is shorter 
        if (length_diff < 0) {
            for (int i = 0; i < currLength; i++) {
                
                // lower case using wrapper class
                charDiff = Character.toLowerCase(strChars[i])
                        - Character.toLowerCase(str.strChars[i]);
                
                //return first difference 
                if (charDiff < 0 || charDiff > 0) {
                    return charDiff;
                }
            }
        }
        
        // perameter is shorter or equality of lengths 
        if (length_diff >= 0) {
            for (int i = 0; i < str.currLength; i++) {
                
                // lower case using wrapper class
                charDiff = Character.toLowerCase(strChars[i])
                        - Character.toLowerCase(str.strChars[i]);
                
                // return first difference 
                if (charDiff < 0 || charDiff > 0) {
                    return charDiff;
                }
            }
        }
        
        // return no difference 
        return charDiff;
    }

    /*  .get method, takes int, returns char at index location 
     int must be in range! 
     */
    public char get(int index) {
        
        // respond to out of bounds indexing
        if (index < 0 || index > currLength - 1) {
            System.out.println("index out of bounds!");
            return '?';
        }
        return strChars[index];
    }
// .toUpper method, ruturns MyString that is in all upper case
    public MyString toUpper() {
        
        // copy origional to leave it unchanged 
        char[] strChars2 = new char[currLength];
        for (int i = 0; i < currLength; i++) {
            
            //upper case using wrapper class
            strChars2[i] = Character.toUpperCase(strChars[i]);
        }
        
        // turn array into string 
        String stringRep = new String(strChars2);
        
        // pass string to MyString constructor 
        MyString Upper = new MyString(stringRep);

        return Upper;

          
    }
    
// .toLower method, returns MyString that is in all lower case
    public MyString toLower() {
        
        // copy origional to leave it unchanged 
        char[] strChars2 = new char[currLength];
        for (int i = 0; i < currLength; i++) {
            
            // lower case using wrapper class
            strChars2[i] = Character.toLowerCase(strChars[i]);
        }
        
        //turn array into string 
        String stringRep = new String(strChars2);
        
        // pass string to MyString constructor 
        MyString Lower = new MyString(stringRep);

        return Lower;

        
    }
    
    /*.indexOf, take MyString peram. returns the starting index of the first 
     occurance of the MyString in the calling object
     If parameter is not found in the calling object, method returns -1 
     */
    public int indexOf(MyString str) {
        
        // assume no occurance initially 
        int index = -1;
        
        // if perameter is longer than calling object, no occurance 
        if (str.currLength > currLength) {

            return index;
        }
        
        // traverse calling array until perameter can no longer fits 
        for (int i = 0; i <= currLength - str.currLength; i++) {
            
           // peramter of length 1 
            if (strChars[i] == str.strChars[0] && str.currLength == 1) {
                index = i;
                return index;
            }
            // search for occurance of first letter in perameter string 
            if (strChars[i] == str.strChars[0]) {
                
                // check for subsequent equality 
                for (int a = 1; a < str.currLength; a++) {
                    if (strChars[i + a] == str.strChars[a]) {
                        
                        // check for first complete occurance 
                        if(a == str.currLength -1){
                           index = i; 
                           return index;  
                        }
                    } 
                    
                    // subsequent equality failed, back to outer for loop 
                    else {
                        break;
                    }
                }  
       
            }
            
        } 
        return index;
    }

    /*.lastIndexOf, take my string peram. returns the starting index of the last 
     occurance of the MyString in the calling object
     If parameter is not found in the calling object, method returns -1   
     */
    public int lastIndexOf(MyString str) {
        
        // assume no occurance initially 
        int index = -1;
        
        // if perameter is longer than calling object, no occurance
        if (str.currLength > currLength) {

            return index;
        }
        // traverse calling array until perameter can no longer fits
        for (int i = 0; i <= currLength - str.currLength; i++) {
            
            // peramter of length 1, set index but keep looking 
            if (strChars[i] == str.strChars[0] && str.currLength == 1) {
                index = i;
            }
            
            //search for occurance of first letter in perameter string
            if (strChars[i] == str.strChars[0]) {
                
                // check for subsequent equality 
                for (int a = 1; a < str.currLength; a++) {
                    if (strChars[i + a] == str.strChars[a]) {
                        
                       // for first complete occurance, set index, keep looking 
                        if(a == str.currLength -1){
                           index = i;
                        }
                      /*potential first occurance failed, index not set 
                        back to outer for loop
                        */  
                    } else if (index == -1){
                        break;
                    }
                }
            }
        }
        return index;
    }

    /*.substring(int n) returns a MyString substring, where n is the starting 
     index. 
     */
    public MyString substring(int start) {
        
        // initialize and populate new array 
        char[] sub = new char[currLength - start];  
        for(int n = start, a = 0; n < currLength; n++, a++){ 
            sub[a] = strChars[n]; 
        }
        // turn array into string 
        String stringRep = new String(sub);

        //pass string to MyString constructor 
        MyString substring = new MyString(stringRep);

        return substring;
    }


    /* overloaded substring(int n, int m) returns a MyString substring,
    where n is the starting index and m is one past the ending index.  
     */
    public MyString substring(int start, int end) {
        
        // initialize and populate array 
        char[] sub = new char[end - start +1];  
        for(int n = start, a = 0; n <= end; n++, a++){ 
            sub[a] = strChars[n]; 
        }
        // turn array into string 
        String stringRep = new String(sub);

        // pass string to MyString constructor 
        MyString substring = new MyString(stringRep);

        return substring;
    }

}
