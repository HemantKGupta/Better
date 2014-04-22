package partition.problem;

public class PartitionProblemRecr {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 1, 2, 2, 1 };

		if (partition(arr, arr.length) == true)
			System.out.println("Can be divided into two subsets of equal sum");
		else
			System.out
					.println("Can not be divided into two subsets of equal sum");
	}
	public static boolean partition(int[] arr, int n) {

		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		return isSubsetSum(arr, n, sum / 2);

	}
	// A utility function that returns true if there is a subset of arr[]
	// with sun equal to given sum
	public static boolean isSubsetSum (int arr[], int n, int sum)
	{
	   // Base Cases
	   if (sum == 0)
	     return true;
	   if (n == 0 && sum != 0)
	     return false;
	 
	   // If last element is greater than sum, then ignore it
	   if (arr[n-1] > sum)
	     return isSubsetSum (arr, n-1, sum);
	 
	   /* else, check if sum can be obtained by any of the following
	      (a) including the last element
	      (b) excluding the last element
	   */
	   return isSubsetSum (arr, n-1, sum) || isSubsetSum (arr, n-1, sum-arr[n-1]);
	}

}