package com.company.CrackingTheCodingInterview.Chapter1;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by bekzodalibayev on 2/8/17.
 */
public class CheckPermutation {
    public static boolean checkIfTwoStringsArePermutation(String string1, String string2){
        Map<Character, Integer> hashtable = new HashMap<>();
        for (char key: string1.toCharArray()) {
            if(hashtable.containsKey(key)){
                int value = hashtable.get(key);
                value++;
                hashtable.replace(key, value);
            }else{
                hashtable.put(key, 1);
            }
        }

        for(char key: string2.toCharArray()){
            if(!hashtable.containsKey(key)){
                return false;
            }
            int value = hashtable.get(key);
            value--;
            if(value == 0){
                hashtable.remove(key);
            } else{
                hashtable.replace(key, value);
            }
        }

        return hashtable.size() == 0;

    }
}
