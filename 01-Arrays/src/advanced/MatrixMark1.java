package advanced;

/**
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that
 * if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.
 */

public class MatrixMark1 {

	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, };

	}

	public static void modifyMatrix(int[][] mat) {
		int R = mat.length;
		int C = mat[0].length;
		int[] row = new int[R];
		int[] col = new int[C];

		int i, j;

		/* Initialize all values of row[] as 0 */
		for (i = 0; i < R; i++) {
			row[i] = 0;
		}

		/* Initialize all values of col[] as 0 */
		for (i = 0; i < C; i++) {
			col[i] = 0;
		}

		// Store the rows and columns to be marked as 1
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				if (mat[i][j] == 1) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		// Modify the input matrix mat[]
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				if (row[i] == 1 || col[j] == 1) {
					mat[i][j] = 1;
				}
			}
		}
	}

}
