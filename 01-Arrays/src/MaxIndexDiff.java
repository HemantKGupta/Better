public class MaxIndexDiff {

	public static void main(String[] args) {
		 int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		 System.out.println(maxIndexDiff(arr, arr.length));

	}

	/*
	 * For a given array arr[], returns the maximum j – i such that arr[j] >
	 * arr[i]
	 */
	public static int maxIndexDiff(int arr[], int n) {
		int maxDiff;
		int i, j;

		int[] LMin = new int[n];
		int[] RMax = new int[n];

		/*
		 * LMin[i] stores the minimum value from
		 * (arr[0], arr[1], ... arr[i])
		 */
		LMin[0] = arr[0];
		for (i = 1; i < n; ++i)
			LMin[i] = Math.min(arr[i], LMin[i - 1]);

		/*
		 * RMax[j] stores the maximum value from
		 * (arr[j], arr[j+1], ..arr[n-1])
		 */
		RMax[n - 1] = arr[n - 1];
		for (j = n - 2; j >= 0; --j)
			RMax[j] = Math.max(arr[j], RMax[j + 1]);

		/*
		 * Find optimum j - i 
		 */
		i = 0;
		j = 0;
		maxDiff = -1;
		while (j < n && i < n) {
			if (LMin[i] < RMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}

		return maxDiff;
	}

}