package search.advanced;

public class PatternSearch04 {

	public static void main(String[] args) {
		char[] txt = "AABAACAADAABAAABAA".toCharArray();
		char[] pat = "AABA".toCharArray();
		search(pat, txt);

	}

	public static void search(char[] pat, char[] txt) {
		int M = pat.length;
		int N = txt.length;
		int i = 0;

		while (i <= N - M) {
			int j;

			/* For current index i, check for pattern match */
			for (j = 0; j < M; j++) {
				if (txt[i + j] != pat[j])
					break;
			}
			if (j == M) 
			{
				System.out.printf("Pattern at index %d \n", i);
				i = i + M;
			} else if (j == 0) {
				i = i + 1;
			} else {
				i = i + j; // slide the pattern by j
			}
		}
	}

}
