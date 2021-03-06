package com.hkg.test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class MyDepthFirstPathsTest {
	
	private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex

    public static void main(String[] args) {
        Graph G = new Graph(5, 18);
        MyDepthFirstPathsTest dfs = new MyDepthFirstPathsTest(G, 0);
        for(int x: dfs.edgeTo){
        	System.out.println(x);
        }
        for (int i = 0; i < G.v; i++) {
            if (dfs.hasPathTo(i)) {
                System.out.printf("%d to %d:  ", 0, i);
                ListIterator<Integer> l = dfs.pathTo(i).listIterator(dfs.pathTo(i).size());
                while (l.hasPrevious()) {
                	int x = l.previous();
                    if (x == 0) System.out.print("-"+x);
                    else        System.out.print("-" + x);
                }
                System.out.println();
            }

            else {
            	System.out.printf("%d to %d:  not connected\n", 0, i);
            }

        }
    }

    
    public MyDepthFirstPathsTest(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.v];
        marked = new boolean[G.v];
        dfs(G, s);
    }

    // depth first search from v
	    private void dfs(Graph G, int v) {
	        marked[v] = true;
	        for (int w : G.adj(v)) {
	            if (!marked[w]) {
	                edgeTo[w] = v;
	                dfs(G, w);
	            }
	        }
	    }

    // is there a path between s and v?
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /*// return a path between s to v; null if no such path
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }*/

    public List<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        List<Integer> path = new LinkedList<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.add(x);
        path.add(s);
        return path;
    }
   
    
}
