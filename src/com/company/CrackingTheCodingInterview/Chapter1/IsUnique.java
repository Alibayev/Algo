package com.company.CrackingTheCodingInterview.Chapter1;

import java.util.Arrays;
import java.util.HashSet;

import static java.lang.System.in;

/**
 * Created by bekzodalibayev on 2/8/17.
 */
public class IsUnique {
    public static boolean checkIfStringIsUniqueWithHashSet(String stringToCheck){
        char[] charArray = stringToCheck.toCharArray();
        HashSet<Character> setOfChars = new HashSet<Character>();
        for(char c:charArray) {
            if (!setOfChars.contains(c)){
                setOfChars.add(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfStringIsUniqueWithoutHashSet(String stringToCheck){
        char[] charArray = stringToCheck.toCharArray();
        Arrays.sort(charArray); //let's assume this is a mergesort O(nlogn)
        for(int i = 0; i < charArray.length; i++){
            if(i < charArray.length - 1 && charArray[i] == charArray[i+1]){
                return false;
            }
        }
        return true;
    }
}
