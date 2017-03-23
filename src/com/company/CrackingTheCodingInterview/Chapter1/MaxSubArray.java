package com.company.CrackingTheCodingInterview.Chapter1;

/**
 * Created by bekzodalibayev on 2/16/17.
 */
public class MaxSubArray {
    public static void main(String[] args){
        int[] array = {-2, 3, 5, -4, -2, 7};
        calculateMaxSubArraySum(array, array.length);
    }

    private static void calculateMaxSubArraySum(int[] array, int length){
        if (length <1) return;
        int globalMax = array[0];
        int localMax = array[0];
        System.out.println();
        for(int i=1; i < length; i++){
            //localMax = Integer.max(array[i], localMax + array[i]);
            localMax = localMax + array[i] > array[i] ? localMax + array[i] : array[i];
            globalMax = localMax > globalMax ? localMax : globalMax;
            //globalMax = Integer.max(localMax, globalMax);
        }
        System.out.println(globalMax);
    }
}
