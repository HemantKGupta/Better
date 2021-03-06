package basic;

public class DP04IterativeLongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println(lisDynamic(arr));
	}

    /**
     * It can be solved by building a LIS array as follow.
     * LIS at any index of array will be one more than the max of
	 * LIS from previous indexes if
     * the current index value is greater than the last value of largest LIS index value
	 *
     * In case the current index value is not more then the LIS for
	 * this index should be set to one (This can be done as initialization)
	 * Finally the max value is LIS array is the result
	 * The complexity of this approach is O(n^2)
     *
     * https://www.youtube.com/watch?v=Ns4LCeeOFS4&list=PLqM7alHXFySGbXhWx7sBJEwY2DnhDjmxm&index=5
     *
     * @param arr
     * @return
     */

	public static int lisDynamic(int arr[]) {
		int i, j, max = 0;
		int n = arr.length;
		int[] lis = new int[n];

		// Initialize the LIS
		for (i = 0; i < n; i++)
			lis[i] = 1;

		// For each value in array from 1 to n
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;

		for (i = 0; i < n; i++)
			if (max < lis[i])
				max = lis[i];

		return max;
	}





}
