package com.company.CrackingTheCodingInterview.Chapter1;

/**
 * Created by bekzodalibayev on 3/5/17.
 */
public class Anagram {
    public static void main(String[] args){
        String first = "bekzod";
        String second = "dozkeb";

        System.out.println(isAnagram(first.toCharArray(), second.toCharArray()));
    }

    public static boolean isAnagram(char[] first, char[] second){
        if(first.length != second.length){
            return false;
        }
        int[] firstAscii =  new int[128];
        int[] secondAscii = new int[128];

        for(int i = 0; i < first.length; i++){
            int char1 = first[i];
            int char2 = second[i];

            firstAscii[char1] = firstAscii[char1] + 1;
            secondAscii[char2] = secondAscii[char2] + 1;
        }

        for(int i = 0; i<128; i++){
            if(firstAscii[i] != secondAscii[i]){
                return false;
            }
        }

        return true;
    }
}
