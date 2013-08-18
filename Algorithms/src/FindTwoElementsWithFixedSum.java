import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTwoElementsWithFixedSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = { 1, 4, 45, 6, 10, -8 };
		int n = 16;
		// System.out.println(hasArrayTwoCandidates(A,16));
		printPairs(A, 16);

	}

	public static boolean hasArrayTwoCandidates(int[] A, int sum) {

		Arrays.sort(A);
		int l = 0;
		int r = A.length - 1;
		while (l < r) {
			if (A[l] + A[r] == sum)
				return true;
			else if (A[l] + A[r] < sum)
				l++;
			else
				r--;
		}
		return false;
	}

	public static void printPairs(int[] arr, int sum) {
		int temp;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			temp = sum - arr[i];
			if (map.containsKey(temp)) {
				System.out.println("The value at index: " + map.get(temp)
						+ " is: " + temp + " and the value at index: " + i
						+ " is: " + arr[i]);
			}
			map.put(arr[i], i);
		}
	}

}