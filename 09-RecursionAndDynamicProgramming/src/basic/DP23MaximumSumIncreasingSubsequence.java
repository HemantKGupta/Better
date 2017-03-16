package basic;

public class DP23MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = { 1, 101, 2, 3, 100, 4, 5 };
		System.out.println(maxSumIS(arr));
	}

	// The maximum sum of increasing subsequence
	public static int maxSumIS(int[] arr) {
		int n = arr.length;
		int i, j, max = 0;
		int[] msis = new int[n];
		
		/* Initialize msis values for all indexes */
		for (i = 0; i < n; i++)
			msis[i] = arr[i];

		/* Compute maximum sum values in bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
					msis[i] = msis[j] + arr[i];

		/* Pick maximum of all msis values */
		for (i = 0; i < n; i++)
			if (max < msis[i])
				max = msis[i];

		return max;
	}

}
