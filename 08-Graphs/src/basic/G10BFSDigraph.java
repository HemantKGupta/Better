package basic;

import util.Digraph;

import java.util.LinkedList;
import java.util.Queue;


public class G10BFSDigraph {

    private static  boolean[] marked;

	public static void main(String[] args) {
		Digraph G = new Digraph("tinyDG.txt");
        System.out.println(G);
        marked =  new boolean[G.V()];

		bfsDigraph(G, 0);

	}

    public static void bfsDigraph(Digraph G, int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        marked[s] = true;
        System.out.println("visited :"+ s);
        q.add(s);
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    System.out.println("visited :"+ w);
                    q.add(w);
                }
            }
        }
    }

}
