package advanced;

/**
 * The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints
 * that from each cell you can either move only to right or down
 */
public class CountAllPathsMatrix {

	public static void main(String[] args) {
		System.out.println(numberOfPaths(2, 3));
		System.out.println(numberOfPathsDP(2, 3));
	}

	// Returns count of possible paths in matrix
	public static int numberOfPaths(int m, int n) {
		// If either row or column number is first
		if (m == 1 || n == 1)
			return 1;

		// If diagonal movements are allowed
		// then the last addition is required.
		return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
		// + numberOfPaths(m-1,n-1);
	}

	// Returns count of possible paths in matrix
	public static int numberOfPathsDP(int m, int n) {
		int[][] count = new int[m][n];

		// Count of paths to reach any cell in first row is 1
		for (int i = 0; i < m; i++)
			count[i][0] = 1;

		// Count of paths to reach any cell in first column is 1
		for (int j = 0; j < n; j++)
			count[0][j] = 1;

		// count of paths for other cells in bottom-up manner
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++)

				// If diagonal movements are allowed
				// then the last addition is required.
				count[i][j] = count[i - 1][j] + count[i][j - 1];
			// + count[i-1][j-1];

		}
		return count[m - 1][n - 1];
	}

}
