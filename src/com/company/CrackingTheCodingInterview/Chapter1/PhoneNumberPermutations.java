package com.company.CrackingTheCodingInterview.Chapter1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by bekzodalibayev on 2/13/17.
 */
public class PhoneNumberPermutations {
    static HashMap<Integer, char[]> phoneNumber;
    public static void main(String[] args){
        int[] input = {2,5,7};
        int n = input.length;
        phoneNumber = new HashMap<>();
        phoneNumber.put(1, new char[]{});
        phoneNumber.put(2,new char[]{'a','b','c'});
        phoneNumber.put(3,new char[]{'d','e','f'});
        phoneNumber.put(4,new char[]{'g','h','i'});
        phoneNumber.put(5,new char[]{'j','k','l'});
        phoneNumber.put(6,new char[]{'m','n','o'});
        phoneNumber.put(7,new char[]{'p','q','r', 's'});
        phoneNumber.put(8,new char[]{'t','u','v'});
        phoneNumber.put(9,new char[]{'w','x','y', 'z'});
        phoneNumber.put(0,new char[]{});

        //printAllPermutationsOfPhoneNumber(input, 0, new char[4]);
        findCut(new int[]{4,2,3});
    }

    static void printAllPermutationsOfPhoneNumber(int[] input, int current, char[] output){
        if(current == input.length){
            System.out.println(String.valueOf(output) + " ");
            return;
        }
        char[] currentChars = phoneNumber.get(input[current]);
        for(int i=0; i<currentChars.length; i++){
            output[current] = phoneNumber.get(input[current])[i];
            printAllPermutationsOfPhoneNumber(input, current + 1, output);
        }
    }

    static void findCut(int[] input){
        int inputLength = input.length;
        if(inputLength<2){
            System.out.println("Array is empty or there's only one  element in the array");
            return;
        }
        if(input[0] < input[inputLength - 1]){
            System.out.println("Array is sorted, there was no cut");
            return;
        }
        int median = inputLength / 2;
        if (inputLength == 2){
            System.out.println("The border is " + input[0] + " and " + input[1]);
            return;
        }

        if (input[0] > input[median]){
            findCut(Arrays.copyOfRange(input, 0, median + 1));
        } else{
            findCut(Arrays.copyOfRange(input, median, inputLength));
        }
    }
}
