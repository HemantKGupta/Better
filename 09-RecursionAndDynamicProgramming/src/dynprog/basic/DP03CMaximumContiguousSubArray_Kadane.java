package dynprog.basic;
public class DP03CMaximumContiguousSubArray_Kadane {

	public static void main(String[] args) {
		int maxSum = maxSumOfSubArrayAllNegative(new int[] { -8, -3, -4, -2, -5, -4 });
		System.out.println(maxSum);
	}

    // Works only if at least there is a positive number
	public static int maxSumOfSubArray(int[] array) {
		int maxSumEndingHere = 0;
		int maxSoFar = 0;
		for (int i = 0; i < array.length; i++) {
            // First get maxSumEndingHere
			maxSumEndingHere = Math.max(0, array[i] + maxSumEndingHere);
            // now get maxSoFar
			maxSoFar = Math.max(maxSoFar, maxSumEndingHere);
		}
		return maxSoFar;
	}

    // Works even if there is no positive number
	public static int maxSumOfSubArrayAllNegative(int[] ar) {
		int maxSoFar = ar[0];
		int maxSumEndingHere = ar[0];
		for (int i = 0; i < ar.length; i++) {
			maxSumEndingHere = Math.max(ar[i], ar[i] + maxSumEndingHere);
			maxSoFar = Math.max(maxSoFar, maxSumEndingHere);
		}
		return maxSoFar;
	}

	public static int[] maxSumOfSubArrayWithIndex(int[] array) {

		int maxSoFar = 0, maxSumEndingHere = 0;
		// Four pointers 2 each to keep the start and end of max sub array till
		// now and current max array
		int startOfMaxSoFar = 0, endofMaxSoFar = 0, startOfMaxSumEndingHere = 0, endOfMaxSumEndingHere = 0;
		for (int i = 0; i < array.length; i++) {
			int sum = array[i] + maxSumEndingHere;
			// if sum is greater than zero, then update the current maxSum and
			// also the end index
			if (0 < sum) {
				maxSumEndingHere = sum;
				endOfMaxSumEndingHere = i;
				// sum has gone negative, reset the start and end index of
				// current maxSum sub array to next index
			} else {
				maxSumEndingHere = 0;
				startOfMaxSumEndingHere = i + 1;
				endOfMaxSumEndingHere = startOfMaxSumEndingHere;
			}
			// If maxSoFar is getting updated, update the start and end indices
			// also
			if (maxSoFar < maxSumEndingHere) {
				maxSoFar = maxSumEndingHere;
				startOfMaxSoFar = startOfMaxSumEndingHere;
				endofMaxSoFar = endOfMaxSumEndingHere;
			}
		}
		int[] subArray = new int[endofMaxSoFar - startOfMaxSoFar + 1];
		System.arraycopy(array, startOfMaxSoFar, subArray, 0, subArray.length);
		return subArray;
	}

}