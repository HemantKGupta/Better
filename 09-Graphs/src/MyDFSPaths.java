import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MyDFSPaths {
	private boolean[] marked; // marked[v] = is there an s-v path?
	private int[] edgeTo; // edgeTo[v] = last edge on s-v path
	private final int s; // source vertex

	public MyDFSPaths(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
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

	// return a path between s to v; null if no such path
	public List<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		List<Integer> path = new LinkedList<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.add(x);
		path.add(s);
		return path;
	}

	public static void main(String[] args) {
		Graph G = new Graph("tinyCG.txt");
		System.out.println(G);
		int s = 0;
		MyDFSPaths dfs = new MyDFSPaths(G, s);

		for (int v = 0; v < G.V(); v++) {
			if (dfs.hasPathTo(v)) {
				System.out.printf("%d to %d:  ", s, v);
				ListIterator<Integer> it = (ListIterator<Integer>) dfs
						.pathTo(v).listIterator(dfs.pathTo(v).size());
				while (it.hasPrevious()) {
					int x = it.previous();
					if (x == s)
						System.out.print(x);
					else
						System.out.print("-" + x);
				}
				System.out.println();
			}

			else {
				System.out.printf("%d to %d:  not connected\n", s, v);
			}

		}
	}

}