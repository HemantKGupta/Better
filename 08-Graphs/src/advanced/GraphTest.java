package advanced;

import util.Graph;

public class GraphTest {
	
	 private boolean[] marked;    // marked[v] = is there an s-v path?
	    private int count;           // number of vertices connected to s

	    

	public static void main(String[] args) {
		GraphTest gt = new GraphTest();
		Graph g = new Graph("tinyCG.txt");
		System.out.println(g);
		gt.marked = new boolean[g.V()];
		gt.dfs(g, 0);
		// File currentDirectory = new File(new File(".").getAbsolutePath());
		// System.out.println(currentDirectory.getAbsolutePath());

	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		System.out.print(", "+v);
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

}
