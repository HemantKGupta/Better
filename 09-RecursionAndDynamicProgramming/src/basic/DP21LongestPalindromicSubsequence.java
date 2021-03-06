package basic;

public class DP21LongestPalindromicSubsequence {

	public static void main(String[] args) {
		System.out.println(lps("BBABCBCAB".toCharArray(), 0, 8));
		System.out.println(lpsDP("BBABCBCAB".toCharArray()));
		
	}
	
	// Returns the length of the longest palindromic subsequence
	public static int lps(char[] seq, int i, int j) {
		if (i == j)
			return 1;
		if (seq[i] == seq[j] && i + 1 == j)
			return 2;
		if (seq[i] == seq[j])
			return lps(seq, i + 1, j - 1) + 2;
		return Math.max(lps(seq, i, j - 1), lps(seq, i + 1, j));
	}

	// Returns the length of the longest palindromic subsequence
	public static int lpsDP(char[] str) {
		int n = str.length;
		int i, j, cl;
		int[][] L = new int[n][n]; 

		// Strings of length 1 are palindrome of lentgh 1
		for (i = 0; i < n; i++)
			L[i][i] = 1;

		// lower diagonal values are useless so not filled
		// cl is length of substring, cl 2 to n
		for (cl = 2; cl <= n; cl++) { 
			// i is starting index of cl
			for (i = 0; i < n - cl + 1; i++) {
				j = i + cl - 1; // j is starting ending index of cl
				if (str[i] == str[j] && cl == 2)
					L[i][j] = 2;
				else if (str[i] == str[j])
					L[i][j] = L[i + 1][j - 1] + 2;
				else
					L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
			}
		}
		return L[0][n - 1];
	}
	
	

}
