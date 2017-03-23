package com.company.CrackingTheCodingInterview.Various;

/**
 * Created by bekzodalibayev on 3/6/17.
 */
public class MatrixSpiral {
    public static void main(String[] args){
        int[][] arr = {{1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}
        };

        printMatrixInSpiralForm(arr,5, 5);
    }
    public static void printMatrixInSpiralForm(int[][] array, int rows, int cols) {
        int i = 0;
        while (rows > 2 || cols > 0) {
            int j = i;
            while (j < cols) {
                System.out.print(array[i][j] + " ");
                j++;
            }

            j = i + 1;
            while (j < rows) {
                System.out.print(array[j][cols - 1] + " ");
                j++;
            }
            cols--;

            j = cols - 1;
            while (j >= i) {
                System.out.print(array[rows - 1][j] + " ");
                j--;
            }
            rows--;
            j = rows - 1;
            while (j > i) {
                System.out.print(array[j][i] + " ");
                j--;
            }
            i++;
        }
    }
}
