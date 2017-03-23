package com.company.CrackingTheCodingInterview.Chapter4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by bekzodalibayev on 3/8/17.
 */
public class TopologicalSort {
    public static void main(String[] args){
        int v = 6;
        LinkedList<Integer> g[]  = new LinkedList[v];
        for(int i = 0; i < v; i++){
            g[i] = new LinkedList<>();
        }
        addEdge(g, 5, 2);
        addEdge(g, 5, 0);
        addEdge(g, 4, 0);
        addEdge(g, 4, 1);
        addEdge(g, 2, 3);
        addEdge(g, 3, 1);

        printInTopologicalOrder(g);
    }
    public static void addEdge(LinkedList<Integer> graph[], int i, int j){
        graph[i].add(j);
    }

    public static void printInTopologicalOrder(LinkedList<Integer> graph[]){
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(visited[i]){
                continue;
            }
            topologicalSort(graph, i, stack, visited);
        }

        while (!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static void topologicalSort(LinkedList<Integer> graph[], int vertex, Stack<Integer> stack, boolean[] visited){
        visited[vertex] = true;
        int i;

        Iterator<Integer> iterator = graph[vertex].iterator();
        while (iterator.hasNext()){
            i = iterator.next();
            if(!visited[i]) {
                topologicalSort(graph, i, stack, visited);
            }
        }

        stack.push(vertex);
    }

}
