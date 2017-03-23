package com.company.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bekzodalibayev on 1/27/17.
 * Pros:
 * 1. Easy to add vertices
 * 2. Easy to add/remove edges
 * 3. May use a lot less memory that adjacency matrix representation, especially in sparse graphs
 */
public class AdjacencyListGraph extends Graph {
    private Map<Integer, ArrayList<Integer>> adjListsMap;

    @Override
    public void implementAddVertex() {
        int v = getNumOfVertices();
        ArrayList<Integer> neightbors = new ArrayList<>();
        adjListsMap.put(v, neightbors);
    }

    @Override
    public void implementAddEdge(int v1, int v2) {
        (adjListsMap.get(v1)).add(v2);
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return new ArrayList<Integer>(adjListsMap.get(v));
    }
}
