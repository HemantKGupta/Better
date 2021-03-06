package basic;

/**
 * Created by root on 10/12/15.
 */
public class DP16AllPairShortestPathEWDirectedFloydWarshall {
    public static int INF = 99999;

    public static void main(String[] args) {
		/* Let us create the following weighted graph
		        10
		   (0)------->(3)
		    |         /|\
		  5 |          |
		    |          | 1
		   \|/         |
		   (1)------->(2)
		        3           */
        int[][] graph = { { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 }
        };

        // Print the solution
        printSolution(floydWarshell(graph));
    }

    // All-pairs shortest path problem using Floyd Warshall algorithm
    public static int[][] floydWarshell(int[][] graph) {
		/*
		 * dist[][] will be the output matrix that will finally have the
		 * shortest distances between every pair of vertices
		 */
        int V = graph[0].length;
        int[][] dist = new int[V][V];
        int i, j, k;


        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];


        //Add all vertices one by one to the set of intermediate vertices
        for (k = 0; k < V; k++) {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++) {
                // Pick all vertices as destination one by one
                for (j = 0; j < V; j++) {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        return dist;
    }

    /* A utility function to print solution */
    public static void printSolution(int[][] dist) {
        System.out
                .println("Following matrix shows the shortest distances between every pair of vertices \n");
        int V = dist[0].length;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF");
                else
                    System.out.print(dist[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }

}
