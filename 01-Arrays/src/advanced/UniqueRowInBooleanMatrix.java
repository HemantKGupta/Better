package advanced;

public class UniqueRowInBooleanMatrix {

	public static void main(String[] args) {
		int[][] m = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 },
				{ 1, 0, 1, 0, 0 } };
		findUniqueRows(m);
	}

	public static void findUniqueRows(int[][] m) {
		TrieNode root = new TrieNode();
		for (int i = 0; i < m.length; ++i) {
			TrieNode tmp = root;
			insert(tmp, m, i, 0);
		}
	}

	public static void insert(TrieNode root, int[][] m, int row, int col) {
		if (col < m[0].length) {
			if (root.child[m[row][col]] == null) {
				root.child[m[row][col]] = new TrieNode();
				insert(root.child[m[row][col]], m, row, col + 1);
			} else {
				insert(root.child[m[row][col]], m, row, col + 1);
			}
		}
		if (col == m[0].length) {
			if (!root.isEnd) {
				System.out.println("new row : " + row);
				root.isEnd = true;
			}
		}
	}
	static class TrieNode {
		boolean isEnd = false;
		TrieNode[] child = new TrieNode[2];
	}

}
