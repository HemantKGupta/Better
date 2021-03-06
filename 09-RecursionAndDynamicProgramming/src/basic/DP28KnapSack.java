package basic;

public class DP28KnapSack {

	/**
	 * @param args
	 */

	public static	    int wt[] = {10, 20, 30};
	public static	    int val[] = {60, 100, 120};

	public static void main(String[] args) {
		    //System.out.println(knapSackRec(50, 3));
		    System.out.println(knapSackDP(50, 3));
	}
	
	// Returns the maximum value that can be put in a knapsack of capacity W
	public static int knapSackRec(int W, int n)
	{
	   // Base Case
	   if (n == 0 || W == 0)
	       return 0;
	 
	   // If weight of the nth item is more than Knapsack capacity W, then
	   // this item cannot be included in the optimal solution
	   if (wt[n-1] > W)
	       return knapSackRec(W, n-1);
	 
	   // Return the maximum of two cases: (1) nth item included (2) not included
	   else return Math.max( val[n-1] + knapSackRec(W-wt[n-1], n-1),
			   knapSackRec(W, n-1)
	                  );
	}
	
	// Returns the maximum value that can be put in a knapsack of capacity W
	public static int knapSackDP(int W, int n)
	{
	   int i, w;
	   int[][] K = new int [n+1][W+1];
	 
	   // Build table K[][] in bottom up manner
	   for (i = 0; i <= n; i++)
	   {
	       for (w = 0; w <= W; w++)
	       {
	           // Initialization
			   if (i==0 || w==0)
	               K[i][w] = 0;
			   // The last weight can be put in the sack
	           else if (wt[i-1] <= w)
	                 K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
	           else
	                 K[i][w] = K[i-1][w];
	       }
	   }
	 
	   return K[n][W];
	}

}
