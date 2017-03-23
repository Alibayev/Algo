package com.company.CrackingTheCodingInterview.Various;

/**
 * Created by bekzodalibayev on 3/6/17.
 */
public class IslandsProblem {
    public static void main(String[] args){
        int[][] ocean = {
                        {1,0,0,0,1},
                        {0,1,0,1,1},
                        {0,1,1,0,0},
                        {0,0,0,0,0},
                        {1,0,0,0,1}
                        };
        IslandsProblem islands = new IslandsProblem();
        System.out.println(islands.getNumberOfIslands(ocean));
    }

    public int getNumberOfIslands(int[][] ocean){
        int rows  = ocean.length;
        int cols = rows > 0 ? ocean[0].length : 0;
        boolean[][] checked = new boolean[rows][cols];
        int numberOfIslands = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!checked[i][j]){
                    if(ocean[i][j] == 1){
                        numberOfIslands++;
                        floodFill(ocean, checked, i, j, rows, cols);
                    } else{
                        checked[i][j] = true;
                    }

                }
            }
        }
        return numberOfIslands;
    }

    public void floodFill(int[][] ocean, boolean[][] checked, int i, int j, int rows, int cols){
        if(ocean[i][j] == 0 || checked[i][j]) {
            return;
        }
        if(ocean[i][j] == 1){
            checked[i][j] = true;
        }

        if(i > 0){
            floodFill(ocean, checked, i - 1, j, rows, cols);
        }

        if(i < rows-1){
            floodFill(ocean, checked, i + 1, j, rows, cols);
        }
        if(j > 0) {
            floodFill(ocean, checked, i, j - 1, rows, cols);
        }
        if(j < cols - 1) {
            floodFill(ocean, checked, i, j + 1, rows, cols);
        }
    }
}
