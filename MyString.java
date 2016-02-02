/*
 * Nathaniel Clay Arnold 
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */

import java.util.Arrays;

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
        ensureCapacity();
        for (int i = 0; i < currLength; i++) {
            strChars[i] = str.charAt(i);
        }
    }

 // Copy Constructor 
    public MyString(MyString str) {
        currLength = str.currLength;
        strChars = new char[currLength]; 
        ensureCapacity(); 
        for (int i = 0; i < currLength; i++) {
            strChars[i] = str.strChars[i];
        }
       
    }

 // Length Method 
    public int length() {
        return currLength;
    }

 // Allocate additional memory for the string 
    private void ensureCapacity() {
        
        if(this.currLength == this.strChars.length){
            char[] cap = new char[this.currLength*2];
        }

    }

 // return a string representation of the MyString object 
    public String toString() {
        
        if(strChars == null){
        String stringRep = new String();  
        return stringRep; 
        }
        
        String stringRep = new String(strChars);
        return stringRep;
    }
    
    /* concat method takes a MyString parameter, returns MyString object
     that is a concatination of of calling object and parameter 
     */

    public MyString concat(MyString str) {
        int comboLength = str.currLength + currLength;
        char[] copyArr = new char[comboLength];

        for (int i = 0; i < currLength; i++) {
            copyArr[i] = strChars[i];
        }

        for (int i = currLength, a = 0; i < comboLength; i++, a++) {
            copyArr[i] = str.strChars[a];
        }

        String stringRep = new String(copyArr);

        MyString Concat = new MyString(stringRep);

        return Concat;
    }
    
    /* overloaded concat method takes a String parameter and concatinates it 
    with the calling MyString object, returning a new MyString object. 
    */
    public MyString concat(String str) {
        int strLength = str.length();
        int comboLength = strLength + currLength;
        char[] copyArr = new char[comboLength];

        for (int i = 0; i < currLength; i++) {
            copyArr[i] = strChars[i];
        }

        for (int i = currLength, a = 0; i < comboLength; i++, a++) {
            copyArr[i] = str.charAt(a);
        }

        String stringRep = new String(copyArr);

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

        if (str.currLength != currLength) {
            return false;
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
        int length_diff = currLength - str.currLength;
        int charDiff = 0;

        if (length_diff < 0) {
            for (int i = 0; i < currLength; i++) {
                charDiff = Character.toLowerCase(strChars[i])
                        - Character.toLowerCase(str.strChars[i]);
                if (charDiff < 0 || charDiff > 0) {
                    return charDiff;
                }
            }
        }

        if (length_diff >= 0) {
            for (int i = 0; i < str.currLength; i++) {
                charDiff = Character.toLowerCase(strChars[i])
                        - Character.toLowerCase(str.strChars[i]);
                if (charDiff < 0 || charDiff > 0) {
                    return charDiff;
                }
            }
        }

        return charDiff;
    }

    /*  .get method, takes int, returns char at index location 
     int must be in range! 
     */
    public char get(int index) {
        if (index < 0 || index > currLength - 1) {
            System.out.println("index out of bounds!");
            return '?';
        }
        return strChars[index];
    }
// .toUpper method, ruturns MyString that is in all upper case
    public MyString toUpper() {
        char[] strChars2 = new char[currLength];
        for (int i = 0; i < currLength; i++) {
            strChars2[i] = Character.toUpperCase(strChars[i]);
        }
        String stringRep = new String(strChars2);

        MyString Upper = new MyString(stringRep);

        return Upper;

          
    }
    
// .toLower method, returns MyString that is in all lower case
    public MyString toLower() {
        char[] strChars2 = new char[currLength];
        for (int i = 0; i < currLength; i++) {
            strChars2[i] = Character.toLowerCase(strChars[i]);
        }
        String stringRep = new String(strChars2);

        MyString Lower = new MyString(stringRep);

        return Lower;

        
    }
    
    /*.indexOf, take MyString peram. returns the starting index of the first 
     occurance of the MyString in the calling object
     If parameter is not found in the calling object, method returns -1 
     */
    public int indexOf(MyString str) {
        int index = -1;
        
        if (str.currLength > currLength) {

            return index;
        }

        for (int i = 0; i <= currLength - str.currLength; i++) {

            if (strChars[i] == str.strChars[0] && str.currLength == 1) {
                index = i;
                return index;
            }

            if (strChars[i] == str.strChars[0]) {
                for (int a = 1; a < str.currLength; a++) {
                    if (strChars[i + a] == str.strChars[a]) {
                        if(a == str.currLength -1){
                           index = i; 
                           return index;  
                        }
                    } 
                    
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
        int index = -1;
        
        if (str.currLength > currLength) {

            return index;
        }

        for (int i = 0; i <= currLength - str.currLength; i++) {

            if (strChars[i] == str.strChars[0] && str.currLength == 1) {
                index = i;
            }

            if (strChars[i] == str.strChars[0]) {
                for (int a = 1; a < str.currLength; a++) {
                    if (strChars[i + a] == str.strChars[a]) {
                        if(a == str.currLength -1){
                           index = i;
                        }
                        
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
        char[] sub = new char[currLength - start];  
        for(int n = start, a = 0; n < currLength; n++, a++){ 
            sub[a] = strChars[n]; 
        }
        String stringRep = new String(sub);

        MyString substring = new MyString(stringRep);

        return substring;
    }


    /* overloaded substring(int n, int m) returns a MyString substring,
    where n is the starting index and m is one past the ending index.  
     */
    public MyString substring(int start, int end) {
        char[] sub = new char[end - start +1];  
        for(int n = start, a = 0; n <= end; n++, a++){ 
            sub[a] = strChars[n]; 
        }
        String stringRep = new String(sub);

        MyString substring = new MyString(stringRep);

        return substring;
    }

}
