package basic;

public class DP14EditDistance {

	public static void main(String[] args) {
		char[] x = "DFGDGBDEGGAB".toCharArray();
		char[] y = "DGGGDGBDEFGAB".toCharArray();
		System.out.println(EditDistanceDP(x, y));
	}

	public static int EditDistanceDP(char[] X, char[] Y) {
		int EDIT_COST = 1;

		int m = X.length + 1;
		int n = Y.length + 1;

		int[][] T = new int[m][n];

		for (int i = 0; i < m; i++)
			T[i][0] = 0;
		for (int j = 0; j < n; j++)
			T[0][j] = 0;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				T[i][j] = min(T[i][j - 1] + EDIT_COST,T[i - 1][j] + EDIT_COST, T[i - 1][j - 1]
						+ (X[i - 1] != Y[j - 1] ? 1 : 0)  );
				/*T[i][j] = Math.min(
						T[i][j - 1] + EDIT_COST,
						Math.min(T[i - 1][j] + EDIT_COST, T[i - 1][j - 1]
								+ (X[i - 1] != Y[j - 1] ? 1 : 0)));*/
			}
		}
		System.out.println("The final matrix is: ");

		for (int i = 0; i < Y.length; i++) {
			if (i == 0) {
				System.out.print("   ");
			}
			System.out.print(" " + Y[i]);
		}
		System.out.println();
		for (int i = 0; i <= X.length; i++) {

			for (int j = 0; j <= Y.length; j++) {
				if (i == 0 && j == 0) {
					System.out.print("  ");
				}
				if (i != 0 && j == 0) {
					System.out.print(X[i - 1] + " ");
				}
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		return T[m - 1][n - 1];
	}

	public static int min(int x, int y, int z){
		return Math.min(x, Math.min(y,z));
	}
}
