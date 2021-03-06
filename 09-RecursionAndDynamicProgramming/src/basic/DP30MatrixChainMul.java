package basic;

public class DP30MatrixChainMul {

	public static void main(String[] args) {
		int arr[] = { 10, 100, 5, 50 };
		System.out.println(MatrixChainOrderDP(arr, 3));
		System.out.println(MatrixChainOrderRec(arr, 1, 3));
	}

	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	// i= 1 and j = n-1 to test
	public static int MatrixChainOrderRec(int p[], int i, int j) {
		if (i == j)
			return 0;

		int k, count;
		int min = Integer.MAX_VALUE;

		for (k = i; k < j; k++) {
			count = MatrixChainOrderRec(p, i, k)
					+ MatrixChainOrderRec(p, k + 1, j) + p[i - 1] * p[k] * p[j];

			if (count < min)
				min = count;
		}

		return min;
	}

	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	public static int MatrixChainOrderDP(int p[], int n) {

		// 0th row and 0th column of m[][] are not used
		int[][] m = new int[n + 1][n + 1];
		int i, j, k, l, q;

		/*
		 * m[i,j] = Min of scalar mul needed to compute the matrix
		 * A[i]A[i+1]...A[j] = A[i..j] where A[i] is p[i-1] x p[i]
		 */

		// cost is zero when multiplying one matrix.
		for (i = 1; i <= n; i++)
			m[i][i] = 0;

		// for each size of 2 or more
		for (l = 2; l <= n; l++) {
			// i is starting index
			for (i = 1; i <= n - l + 1; i++) {
				j = i + l - 1; // j is ending index
				m[i][j] = Integer.MAX_VALUE;
				for (k = i; k < j; k++) {
					q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (q < m[i][j])
						m[i][j] = q;
				}
			}
		}
		return m[1][n];
	}

}
