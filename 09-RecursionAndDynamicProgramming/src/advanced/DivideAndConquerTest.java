package advanced;

public class DivideAndConquerTest {

	public static void main(String[] args) {
		   int arr[] = {2, 3, 4, 5, 7};
		   System.out.println(maxSubArraySum(arr, 0, arr.length-1));
	}
	// Find the maximum possible sum in prices[] auch that prices[m] is part of it
	public static int maxCrossingSum(int arr[], int l, int m, int h)
	{
	    // Include elements on left of mid.
	    int sum = 0;
	    int left_sum = Integer.MIN_VALUE;
	    for (int i = m; i >= l; i--)
	    {
	        sum = sum + arr[i];
	        if (sum > left_sum)
	          left_sum = sum;
	    }
	 
	    // Include elements on right of mid
	    sum = 0;
	    int right_sum = Integer.MIN_VALUE;
	    for (int i = m+1; i <= h; i++)
	    {
	        sum = sum + arr[i];
	        if (sum > right_sum)
	          right_sum = sum;
	    }
	 
	    // Return sum of elements on left and right of mid
	    return left_sum + right_sum;
	}
	 
	// Returns sum of maxium sum subarray in aa[l..h]
	public static int maxSubArraySum(int arr[], int l, int h)
	{
	   // Base Case: Only one element
	   if (l == h)
	     return arr[l];
	 
	   // Find middle point
	   int m = (l + h)/2;
	 
	   /* Return maximum of following three possible cases
	      a) Maximum subarray sum in left half
	      b) Maximum subarray sum in right half
	      c) Maximum subarray sum such that the subarray crosses the midpoint */
	   return Math.max(maxSubArraySum(arr, l, m),
	              Math.max(maxSubArraySum(arr, m+1, h),
	              maxCrossingSum(arr, l, m, h)));
	}
	 

}
