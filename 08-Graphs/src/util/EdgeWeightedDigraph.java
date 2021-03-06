package util;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/*************************************************************************
 *  Compilation:  javac EdgeWeightedDigraph.java
 *  Execution:    java EdgeWeightedDigraph V E
 *  Dependencies: Set.java DirectedEdge.java
 *
 *  An edge-weighted digraph, implemented using adjacency lists.
 *
 *************************************************************************/

/**
 *  The <tt>EdgeWeightedDigraph</tt> class represents an directed graph of vertices
 *  named 0 through V-1, where each edge has a real-valued weight.
 *  It supports the following operations: add an edge to the graph,
 *  iterate over all of edges leaving a vertex.
 *  Parallel edges and self-loops are permitted.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/44sp">Section 4.4</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */



public class EdgeWeightedDigraph {
    private int V;
    private int E;
    private Set<DirectedEdge>[] adj;
    
    /**
     * Create an empty edge-weighted digraph with V vertices.
     */
    public EdgeWeightedDigraph(int V) {
        if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Set<DirectedEdge>[]) new Set[V];
        for (int v = 0; v < V; v++)
            adj[v] = new HashSet<DirectedEdge>();
    }

   /**
     * Create a edge-weighted digraph with V vertices and E edges.
     */
    public EdgeWeightedDigraph(int V, int E) {
        this(V);
        if (E < 0) throw new RuntimeException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = (int) (Math.random() * V);
            int w = (int) (Math.random() * V);
            double weight = Math.round(100 * Math.random()) / 100.0;
            DirectedEdge e = new DirectedEdge(v, w, weight);
            addEdge(e);
        }
    }

   
   /**
     * Copy constructor.
     */
    public EdgeWeightedDigraph(EdgeWeightedDigraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<DirectedEdge> reverse = new Stack<DirectedEdge>();
            for (DirectedEdge e : G.adj[v]) {
                reverse.push(e);
            }
            for (DirectedEdge e : reverse) {
                adj[v].add(e);
            }
        }
    }

   /**
     * Return the number of vertices in this digraph.
     */
    public int V() {
        return V;
    }

   /**
     * Return the number of edges in this digraph.
     */
    public int E() {
        return E;
    }


   /**
     * Add the directed edge e to this digraph.
     */
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
        E++;
    }


   /**
     * Return the edges incident from vertex v as an Iterable.
     * To iterate over the edges incident from vertex v in digraph G, use foreach notation:
     * <tt>for (DirectedEdge e : G.adj(v))</tt>.
     */
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

   /**
     * Return all edges in this digraph as an Iterable.
     * To iterate over the edges in the digraph, use foreach notation:
     * <tt>for (DirectedEdge e : G.edges())</tt>.
     */
    public Iterable<DirectedEdge> edges() {
        Set<DirectedEdge> list = new HashSet<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    } 

   /**
     * Return number of edges incident from v.
     */
    public int outdegree(int v) {
        return adj[v].size();
    }



   /**
     * Return a string representation of this graph.
     */
    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    
    public EdgeWeightedDigraph(String filename ) {    	
    	
    	try {
    		String dir = System.getProperty("user.dir");
    		
    		String filePath = dir+File.separator+"src"+File.separator+filename;
			Scanner s = new Scanner(
					new File(filePath));
			int V = new Integer(s.nextLine());
			int E = new Integer(s.nextLine());
			if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
	        this.V = V;
	        this.E = 0;
	        adj = (Set<DirectedEdge>[]) new Set[V];
	        for (int v = 0; v < V; v++) {
	            adj[v] = new HashSet<DirectedEdge>();
	        }
   		    for (int e = 0; e < E; e++) {
				String line = s.nextLine();
				line = line.trim();
				String[] vers = line.split("\\p{javaWhitespace}+");
				int v = new Integer(vers[0]);
				int w = new Integer(vers[1]);
				double weight = new Double(vers[2]);
				DirectedEdge edge = new DirectedEdge(v, w, weight);
		        addEdge(edge);
				
			} 
   		    s.close();
   		 
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}	
    }

    /**
     * Test client.
     */
    public static void main(String[] args) {
       
        EdgeWeightedDigraph G = new EdgeWeightedDigraph("tinyEWD.txt");
        System.out.println(G);
    }

}
