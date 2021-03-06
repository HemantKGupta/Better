package com.hkg.test;

import java.util.Stack;

public class MyCycleTest {
	private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public MyCycleTest(Graph G) {
        if (hasSelfLoop(G)) return;
        if (hasParallelEdges(G)) return;
        marked = new boolean[G.v];
        edgeTo = new int[G.v];
        for (int v = 0; v < G.v; v++)
            if (!marked[v])
                dfs(G, -1, v);
    }


    // does this graph have a self loop?
    // side effect: initialize cycle to be self loop
    private boolean hasSelfLoop(Graph G) {
        for (int i = 0; i < G.v; i++) {
            for (int w : G.adj(i)) {
                if (i == w) {
                    cycle = new Stack<Integer>();
                    cycle.push(i);
                    cycle.push(i);
                    return true;
                }
            }
        }
        return false;
    }

    // does this graph have two parallel edges?
    // side effect: initialize cycle to be two parallel edges
    private boolean hasParallelEdges(Graph G) {
        marked = new boolean[G.v];

        for (int i = 0; i < G.v; i++) {

            // check for parallel edges incident to v
            for (int w : G.adj(i)) {
                if (marked[w]) {
                	
                    cycle = new Stack<Integer>();
                    cycle.push(i);
                    cycle.push(w);
                    cycle.push(i);
                    return true;
                }
                marked[w] = true;
            }

            // reset so marked[v] = false for all v
            for (int w : G.adj(i)) {
                marked[w] = false;
            }
        }
        return false;
    }

    public boolean hasCycle()        { return cycle != null; }
    public Iterable<Integer> cycle() { return cycle;         }

    private void dfs(Graph G, int u, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {

            // short circuit if cycle already found
            if (cycle != null) return;

            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, v, w);
            }

            // check for cycle (but disregard reverse of edge leading to v)
            else if (w != u) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    // test client
    public static void main(String[] args) {
        Graph G = new Graph(10, 15);
        System.out.println(G);

        MyCycleTest finder = new MyCycleTest(G);
        if (finder.hasCycle()) {
            for (int v : finder.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println("Cycle.");
        }
        else {
            System.out.println("Graph is acyclic");
        }
    }
}
