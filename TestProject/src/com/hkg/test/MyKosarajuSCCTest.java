package com.hkg.test;

import java.util.LinkedList;
import java.util.Queue;

public class MyKosarajuSCCTest {
	private boolean[] marked;     // marked[v] = has vertex v been visited?
    private int[] id;             // id[v] = id of strong component containing v
    private int count;            // number of strongly-connected components


    public MyKosarajuSCCTest(Digraph G) {

        // compute reverse postorder of reverse graph
        MyDirectedDepthFirstOrderTest dfs = new MyDirectedDepthFirstOrderTest(G.reverse());

        // run DFS on G, using reverse postorder to guide calculation
        marked = new boolean[G.v];
        id = new int[G.v];
        for (int v : dfs.reversePost()) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }

        // check that id[] gives strong components
        assert check(G);
    }

    // DFS on graph G
    private void dfs(Digraph G, int v) { 
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    // return the number of strongly connected components
    public int count() { return count; }

    // are v and w strongly connected?
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    // id of strong component containing v
    public int id(int v) {
        return id[v];
    }

    // does the id[] array contain the strongly connected components?
    private boolean check(Digraph G) {
        MyTransitiveClosureTest tc = new MyTransitiveClosureTest(G);
        for (int v = 0; v < G.v; v++) {
            for (int w = 0; w < G.v; w++) {
                if (stronglyConnected(v, w) != (tc.reachable(v, w) && tc.reachable(w, v)))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph();
        System.out.println(G);
        MyKosarajuSCCTest scc = new MyKosarajuSCCTest(G);

        // number of connected components
        int M = scc.count();
        System.out.println(M + " components");

        // compute list of vertices in each strong component
        Queue<Integer>[] components = (LinkedList<Integer>[]) new LinkedList[M];
        for (int i = 0; i < M; i++) {
            components[i] = new LinkedList<Integer>();
        }
        for (int v = 0; v < G.v; v++) {
            components[scc.id(v)].add(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

    }
}
