package com.company.CrackingTheCodingInterview.Chapter1;

/**
 * Created by bekzodalibayev on 2/25/17.
 */
public class MaxWindowOf1s {
    public static void main(String[] args){
        int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int k = 2;
        int n =  arr.length;
        System.out.print("Indexes of zeroes to be flipped are ");
        printMaxWindow(arr, n, k);
    }

    //n is the size of array
    //k is the size of a window
    private static void printMaxWindow(int[] arr, int n, int k){
        int wR = 0, wL = 0, bestL = 0, bestWindow = 0, zeroCount = 0;

        while(wR < n){
            if(zeroCount <= k){
                if(arr[wR] == 0){
                    zeroCount++;
                }
                wR++;
            } else{
                if(arr[wL] == 0){
                    zeroCount--;
                }
                wL ++;
            }

            if(wR - wL > bestWindow){
                bestWindow = wR - wL;
                bestL = wL;
            }
        }

        for(int i=0; i < bestWindow; i++){
            if(arr[bestL + i] == 0){
                System.out.print(bestL + i + " ");
            }
        }
    }
}
