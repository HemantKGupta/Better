package com.hkg.test;

import java.util.LinkedList;
import java.util.Queue;

public class MyConnectedComponentsTest {

	private boolean[] marked; // marked[v] = has vertex v been marked?
	private int[] id; // id[v] = id of connected component containing v
	private int[] size; // size[id] = number of vertices in given component
	private int count; // number of connected components

	public MyConnectedComponentsTest(Graph G) {
		marked = new boolean[G.v];
		id = new int[G.v];
		size = new int[G.v];
		for (int i = 0; i < G.v; i++) {
			if (!marked[i]) {
				dfs(G, i);
				count++;
			}
		}
	}

	// depth first search
	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		size[count]++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	// id of connected component containing v
	public int id(int v) {
		return id[v];
	}

	// size of connected component containing v
	public int size(int v) {
		return size[id[v]];
	}

	// number of connected components
	public int count() {
		return count;
	}

	// are v and w in the same connected component?
	public boolean areConnected(int v, int w) {
		return id(v) == id(w);
	}

	// test client
	public static void main(String[] args) {
		Graph G = new Graph(5, 3);
		MyConnectedComponentsTest cc = new MyConnectedComponentsTest(G);

		// number of connected components
		int M = cc.count();
		System.out.println(M + " components");

		// compute list of vertices in each connected component
		Queue<Integer>[] components = (LinkedList<Integer>[]) new LinkedList[M];
		for (int i = 0; i < M; i++) {
			components[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < G.v; i++) {
			components[cc.id(i)].add(i);
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
