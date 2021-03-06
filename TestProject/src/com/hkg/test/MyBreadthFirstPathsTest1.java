package com.hkg.test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class MyBreadthFirstPathsTest1 {
	private boolean[] marked; // Is a shortest path to this vertex known?
	 private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
	private int s;
	
	public static void main(String[] args) {
        //Graph G = new Graph(5, 7);
		Graph G = new Graph();
        System.out.println(G);
        int s=0;
        MyBreadthFirstPathsTest1 search = new MyBreadthFirstPathsTest1(G, s);
        for (int i = 0; i < G.v; i++) {
            if (search.hasPathTo(i)) {
                System.out.printf("%d to %d:  ", 0, i);
                ListIterator<Integer> l = search.pathTo(i).listIterator(search.pathTo(i).size());
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

	public MyBreadthFirstPathsTest1(Graph G, int s) {
		marked = new boolean[G.v];
		edgeTo = new int[G.v];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		marked[s] = true; // Mark the source
		//System.out.println("Visited node: "+s); // print source visited after marking
		queue.add(s); // and put it on the queue.
		while (!queue.isEmpty()) {
			int v = queue.remove(); // Remove next vertex from the queue.
			for (int w : G.adj(v))
				if (!marked[w]) // For every unmarked adjacent vertex,
				{   
					edgeTo[w] = v;
					marked[w] = true; // mark it because path is known,
					//System.out.println("Visited node: "+w); //print as visited after marking
					queue.add(w); // and add it to the queue.
				}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public List<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        List<Integer> path = new LinkedList<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.add(x);
        path.add(s);
        return path;
    }
}
