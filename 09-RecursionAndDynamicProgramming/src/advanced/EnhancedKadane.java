package advanced;

public class EnhancedKadane {

	public static void main(String[] args) {
		 int a[] =  {11, 10, -20, 5, -3, -5, 8, -13, 10};
		 System.out.println(maxCircularSum(a, a.length));
	}

	// The function returns maximum circular contiguous sum in a[]
	public static int maxCircularSum(int a[], int n) {
		// Case 1: get the maximum sum using standard kadane's algorithm
		int maxKadane = kadane(a, n);

		// Case 2: Now find the maximum sum that includes corner elements.
		int maxWrap = 0, i;
		for (i = 0; i < n; i++) {
			maxWrap += a[i]; // Calculate array-sum
			a[i] = -a[i]; // invert the array (change sign)
		}
		System.out.println("maxKadane "+maxKadane);
		System.out.println("maxWrap "+maxWrap);
		
		int newKadane = kadane(a, n);
		// max sum with corner elements will be:
		// array-sum - (-max subarray sum of inverted array)
		System.out.println("newKadane "+newKadane);
		maxWrap = maxWrap + newKadane;

		// The maximum circular sum will be maximum of two sums
		return (maxWrap > maxKadane) ? maxWrap : maxKadane;
	}

	// Standard Kadane's algorithm to find maximum subarray sum
	// See http://www.geeksforgeeks.org/archives/576 for details
	public static int kadane(int a[], int n) {
		int max_so_far = 0, max_ending_here = 0;
		int i;
		for (i = 0; i < n; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_ending_here < 0)
				max_ending_here = 0;
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}

}
