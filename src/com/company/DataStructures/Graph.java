package com.company.DataStructures;

import java.util.List;

/**
 * Created by bekzodalibayev on 1/27/17.
 */
public abstract class Graph {
    private int numOfVertices;
    private int numOfEdges;

    public Graph(){
        numOfVertices = 0;
        numOfEdges = 0;
    }


    public int getNumOfVertices() {
        return numOfVertices;
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public void addVertex(){
        implementAddVertex();
        numOfVertices++;
    }
    public abstract void implementAddVertex();

    public void addEdge(int v1, int v2){
        implementAddEdge(v1, v2);
        numOfEdges++;
    }
    public abstract void implementAddEdge(int v1, int v2);

    public abstract List<Integer> getNeighbors(int v);
}
