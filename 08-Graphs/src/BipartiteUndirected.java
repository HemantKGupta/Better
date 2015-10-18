import java.util.ArrayDeque;
import java.util.Deque;


public class BipartiteUndirected {

	public static void main(String[] args) {
		  Graph G = new Graph("tinyCG.txt");
		  isBipartite = true;
	        color  = new boolean[G.V()];
	        marked = new boolean[G.V()];
	        edgeTo = new int[G.V()];
	        isBipartite(G, 0);
	        System.out.println(isBipartite);
	        System.out.println(cycle);
	        

	}
	
	private static boolean isBipartite;   // is the graph bipartite?
    private static boolean[] color;       // color[v] gives vertices on one side of bipartition
    private static boolean[] marked;      // marked[v] = true if v has been visited in DFS
    private static int[] edgeTo;          // edgeTo[v] = last edge on path to v
    private static Deque<Integer> cycle= null;  // odd-length cycle
    
	public static void isBipartite(Graph G, int v) { 
        marked[v] = true;
        for (int w : G.adj(v)) {

            if (cycle != null) return;
            
            if (!marked[w]) {
                edgeTo[w] = v;
                color[w] = !color[v];
                isBipartite(G, w);
            } 

            // if v-w create an odd-length cycle, find it
            else if (color[w] == color[v]) {
                isBipartite = false;
                cycle = new ArrayDeque<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.offer(x);
                }
                cycle.offer(w);
                cycle.offer(v);
            }
        }
    }

}