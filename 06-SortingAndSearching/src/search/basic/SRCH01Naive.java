package search.basic;

public class SRCH01Naive {

	public static void main(String[] args) {
		char[] txt = "AABAACAADAABAAABAA".toCharArray();
		char[] pat = "AABA".toCharArray();
		naiveSearch(pat, txt);
	}

	public static void naiveSearch(char[] pat, char[] txt) {
		int M = pat.length;
		int N = txt.length;

		/* A loop to slide pat[] one by one */
		for (int i = 0; i <= N - M; i++) {
			int j;

			/* For current index i, check for pattern match */
			for (j = 0; j < M; j++) {
				if (txt[i + j] != pat[j])
					break;
			}
			if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
			{
				System.out.printf("Pattern found at index %d \n", i);
			}
		}
	}

}
