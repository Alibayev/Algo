package com.company.DataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bekzodalibayev on 1/27/17.
 * Pros:
 * 1. Fast to add/remove egdes
 * 2. Fast to test for edges
 * 3. Good for algebraic representation/manipulations
 *
 * Cons:
 * 1. Slow to add/remove vertices
 * 2. Requires a lot of memory - because most vertices are not connected to most other vertices. Thinks social network, maps and etc
 */
public class AdjacencyMatrixGraph extends Graph {
    private int[][] adjMatrix;

    public AdjacencyMatrixGraph(){
        adjMatrix = new int[10][10];
    }
    @Override
    public void implementAddVertex() {
        int v = getNumOfVertices();
        if(v >= adjMatrix.length) {
            int[][] newAdjMatrix = new int[v * 2][v * 2];
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newAdjMatrix;
        }
        for(int i=0; i < adjMatrix[v].length; i++){
            adjMatrix[v][i] = 0;
        }
    }

    @Override
    public void implementAddEdge(int v1, int v2) {
        adjMatrix[v1][v2] = 1;
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        for(int i=0; i < getNumOfVertices(); i++){
            if(adjMatrix[v][i] != 0) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }
}
