/*
package advanced;


import java.util.LinkedList;
import java.util.Queue;

public class MyLazyPrimMSTTest {
	private double weight; // total weight of MST
	private Queue<Edge> mst; // edges in the MST
	private boolean[] marked; // marked[v] = true if v on tree
	private MinPQ<Edge> pq; // edges with one endpoint in tree

	// compute minimum spanning forest of G
	public MyLazyPrimMSTTest(EdgeWeightedGraph G) {
		mst = new LinkedList<Edge>();
		pq = new MinPQ<Edge>();
		marked = new boolean[G.v];
		for (int i = 0; i < G.v; i++)
			// run Prim from all vertices to
			if (!marked[i])
				prim(G, i); // get a minimum spanning forest

		// check optimality conditions
		assert check(G);
	}

	// run Prim's algorithm
	private void prim(EdgeWeightedGraph G, int s) {
		scan(G, s);
		while (!pq.isEmpty()) { // better to stop when mst has V-1 edges
			Edge e = pq.delMin(); // smallest edge on pq
			int v = e.either(), w = e.other(v); // two endpoints
			assert marked[v] || marked[w];
			if (marked[v] && marked[w])
				continue; // lazy, both v and w already scanned
			mst.add(e); // add e to MST
			weight += e.weight();
			if (!marked[v])
				scan(G, v); // v becomes part of tree
			if (!marked[w])
				scan(G, w); // w becomes part of tree
		}
	}

	// add all edges e incident to v onto pq if the other endpoint has not yet
	// been scanned
	private void scan(EdgeWeightedGraph G, int v) {
		assert !marked[v];
		marked[v] = true;
		for (Edge e : G.adj(v))
			if (!marked[e.other(v)])
				pq.insert(e);
	}

	// return edges in MST as an Iterable
	public Iterable<Edge> edges() {
		return mst;
	}

	// return weight of MST
	public double weight() {
		return weight;
	}

	// check optimality conditions (takes time proportional to E V lg* V)
	private boolean check(EdgeWeightedGraph G) {

		// check weight
		double totalWeight = 0.0;
		for (Edge e : edges()) {
			totalWeight += e.weight();
		}
		double EPSILON = 1E-12;
		if (Math.abs(totalWeight - weight()) > EPSILON) {
			System.err.printf(
					"Weight of edges does not equal weight(): %f vs. %f\n",
					totalWeight, weight());
			return false;
		}

		// check that it is acyclic
		UF uf = new UF(G.v);
		for (Edge e : edges()) {
			int v = e.either(), w = e.other(v);
			if (uf.connected(v, w)) {
				System.err.println("Not a forest");
				return false;
			}
			uf.union(v, w);
		}

		// check that it is a spanning forest
		for (Edge e : edges()) {
			int v = e.either(), w = e.other(v);
			if (!uf.connected(v, w)) {
				System.err.println("Not a spanning forest");
				return false;
			}
		}

		// check that it is a minimal spanning forest (cut optimality
		// conditions)
		for (Edge e : edges()) {
			int v = e.either(), w = e.other(v);

			// all edges in MST except e
			uf = new UF(G.v);
			for (Edge f : mst) {
				int x = f.either(), y = f.other(x);
				if (f != e)
					uf.union(x, y);
			}

			// check that e is min weight edge in crossing cut
			for (Edge f : G.edges()) {
				int x = f.either(), y = f.other(x);
				if (!uf.connected(x, y)) {
					if (f.weight() < e.weight()) {
						System.err.println("Edge " + f
								+ " violates cut optimality conditions");
						return false;
					}
				}
			}

		}

		return true;
	}

	public static void main(String[] args) {
		// EdgeWeightedGraph G = new EdgeWeightedGraph(10, 25 );
		EdgeWeightedGraph G = new EdgeWeightedGraph();
		System.out.println(G);
		MyLazyPrimMSTTest mst = new MyLazyPrimMSTTest(G);
		for (Edge e : mst.edges()) {
			System.out.println(e);
		}
		System.out.printf("%.5f\n", mst.weight());
	}

}
*/
