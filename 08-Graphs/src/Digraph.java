import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

 

public class Digraph {
    private int V;
    private int E;
    private Set<Integer>[] adj;
    
   /**
     * Create an empty digraph with V vertices.
     * @throws java.lang.IllegalArgumentException if V < 0
     */
    public Digraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Set<Integer>[]) new Set[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet<Integer>();
        }
    }

   /**
     * Copy constructor.
     */
    public Digraph(Digraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
        
   /**
     * Return the number of vertices in the digraph.
     */
    public int V() {
        return V;
    }

   /**
     * Return the number of edges in the digraph.
     */
    public int E() {
        return E;
    }

   /**
     * Add the directed edge v->w to the digraph.
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
     */
    public void addEdge(int v, int w) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
        adj[v].add(w);
        E++;
    }

   /**
     * Return the list of vertices pointed to from vertex v as an Iterable.
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
     */
    public Iterable<Integer> adj(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        return adj[v];
    }

   /**
     * Return the reverse of the digraph.
     */
    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

   /**
     * Return a string representation of the digraph.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    
    public void printEdges(){
    	for (int v = 0; v < V; v++)
            for (int w : adj(v))
                System.out.println(v + "->" + w);
    }

   /**
     * Test client.
     */
    public Digraph(String filename) {
    	
    	
    	try {
    		String dir = System.getProperty("user.dir");
    		
    		String filePath = dir+File.separator+"src"+File.separator+filename;
			Scanner s = new Scanner(
					new File(filePath));
			int V = new Integer(s.nextLine());
			int E = new Integer(s.nextLine());
			if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
	        this.V = V;
	        this.E = E;
	        adj = (Set<Integer>[]) new Set[V];
	        for (int v = 0; v < V; v++) {
	            adj[v] = new HashSet<Integer>();
	        }
   		    for (int e = 0; e < E; e++) {
				String line = s.nextLine();
				line = line.trim();
				String[] vers = line.split("\\p{javaWhitespace}+");
				int p = new Integer(vers[0]);
				int q = new Integer(vers[1]);
				addEdge(p, q);
			} 
   		    s.close();
   		 
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}	
        
       
       
    }

}
