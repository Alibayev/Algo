package com.company.CrackingTheCodingInterview.Chapter4;

import java.util.LinkedList;

/**
 * Created by bekzodalibayev on 3/9/17.
 */
public class DFSGraph {
    LinkedList<Integer> adj[];

    public static void main(String[] args){
        DFSGraph g = new DFSGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
    }

    public DFSGraph(int v){
        adj = new LinkedList[v];

        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j){
        adj[i].add(j);
    }

    public void DFS(int v){
        boolean visited[] = new boolean[v];

        for(int i = 0; i < v; i++){
            if(!visited[i]){
                DFSUtil(i, visited);
            }
        }
    }

    public void DFSUtil(int currentNode, boolean visited[]){
        visited[currentNode] = true;
        //System.out.print(graph.);
    }
}
