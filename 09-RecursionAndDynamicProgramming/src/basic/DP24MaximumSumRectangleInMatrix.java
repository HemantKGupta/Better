package basic;

public class DP24MaximumSumRectangleInMatrix {

	public static void main(String[] args) {
		int[][] M = {	{1, 2, -1, -4, -20},
                		{-8, -3, 4, 2, 1},
                		{3, 8, 10, 1, 3},
                		{-4, -1, 1, 7, -6}
               		};
		//mmfindMaxSum(M);

	}
	// Implementation of Kadane's algorithm for 1D array. The function returns the
	// maximum sum and stores starting and ending indexes of the maximum sum subarray
	// at addresses pointed by start and finish pointers respectively.
	public static int[] kadane(int[] arr)
	{
	    // initialize sum, maxSum and
	    int sum = 0, maxSum = Integer.MIN_VALUE, i;
	    int[] results =  new int[3];
	    int n = arr.length;
	    // Just some initial value to check for all negative values case
	    int finish = -1;
	    int start = 0; 
	    // local variable
	    int local_start = 0;
	 
	    for (i = 0; i < n; ++i)
	    {
	        sum += arr[i];
	        if (sum < 0)
	        {
	            sum = 0;
	            local_start = i+1;
	        }
	        else if (sum > maxSum)
	        {
	            maxSum = sum;
	            start = local_start;
	            finish = i;
	        }
	    }
	 
	     // There is at-least one non-negative number
	    if (finish != -1){
	    	results[0]= maxSum;
		    results[1]= start;
		    results[2]=finish;
	        return results;
	    }
	    // Special Case: When all numbers in prices[] are negative
	    maxSum = arr[0];
	    start = finish = 0;
	 
	    // Find the maximum element in array
	    for (i = 1; i < n; i++)
	    {
	        if (arr[i] > maxSum)
	        {
	            maxSum = arr[i];
	            start = finish = i;
	        }
	    }
	    results[0]= maxSum;
	    results[1]= start;
	    results[2]=finish;
	    return results;
	}
	 
	// The main function that finds maximum sum rectangle in M[][]
	public static void findMaxSum(int[][] M)
	{
	    // Variables to store the final output
	    int maxSum = Integer.MIN_VALUE, finalLeft, finalRight, finalTop, finalBottom;
	 
	    int ROW = M.length;
	    int COL = M[0].length;
	    int left, right, i;
	    int  sum, start, finish;
	    int[] temp = new int[ROW];
	 
	    // Set the left column
	    for (left = 0; left < COL; ++left)
	    {
	 
	        // Set the right column for the left column set by outer loop
	        for (right = left; right < COL; ++right)
	        {
	            // Calculate sum between current left and right for every row 'i'
	            for (i = 0; i < ROW; ++i)
	                temp[i] += M[i][right];
	 
	            // Find the maximum sum subarray in temp[]. The kadane() function
	            // also sets values of start and finish.  So 'sum' is sum of
	            // rectangle between (start, left) and (finish, right) which is the
	            //  maximum sum with boundary columns strictly as left and right.
	            //sum = kadane(temp);
	 
	            // Compare sum with maximum sum so far. If sum is more, then update
	            // maxSum and other output values
	           /* if (sum > maxSum)
	            {
	                maxSum = sum;
	                finalLeft = left;
	                finalRight = right;
	                finalTop = start;
	                finalBottom = finish;
	            }*/
	        }
	    }
	 
	    // Print final values
	 //   System.out.printf("(Top, Left) (%d, %d)\n", finalTop, finalLeft);
	 //   System.out.printf("(Bottom, Right) (%d, %d)\n", finalBottom, finalRight);
	  //  System.out.printf("Max sum is: %d\n", maxSum);
	}

}
