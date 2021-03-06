package advanced;

public class MinJumps {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 1, 0, 9 };
		System.out.println(minJumps(arr));
	}

	// Returns minimum number of jumps to reach arr[n-1] from arr[0]
	public static int minJumps(int arr[]) {
		int n = arr.length;
		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;

		int[] jumps = new int[n]; // jumps[n-1] will hold the result
		int i, j;
		jumps[0] = 0;

		// Find the minimum number of jumps to reach arr[i]
		// from arr[0], and assign this value to jumps[i]
		for (i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			// Check with all jumps less than i and
			// find from where i can be reached
			for (j = 0; j < i; j++) {
				// j is reachable and not marked
				if (j + arr[j] >= i && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = jumps[j] + 1;
					break;
				}
			}
		}
		return jumps[n - 1];
	}

}
