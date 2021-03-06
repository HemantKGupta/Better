package search.advanced;

import java.util.Arrays;

public class PatternSearch06_FA_Better {
	private static final int NO_OF_CHARS = 4;

	public static void main(String[] args) {
		//char[] txt = "AABAACAADAABAAABAA".toCharArray();
		int[] pat = {0,1,0,1,0,2,0};
		//search(pa;t, txt);
		int M =  pat.length;
		int[][] TF = new int[M + 1][NO_OF_CHARS];
		computeTransFun(pat,M, TF);
	}

	public static void computeTransFun(int[] pat, int M, int[][] TF) {
		int i, lps = 0, x;

		// Fill entries in first row
		for (x = 0; x < NO_OF_CHARS; x++)
			TF[0][x] = 0;
		
		print2DArray(TF);
		TF[0][pat[0]] = 1;

		for (i = 1; i < M; i++) {
			for (x = 0; x < NO_OF_CHARS; x++)
				TF[i][x] = TF[lps][x];

			// Update the entry corresponding to this character
			int temp = pat[i];
			System.out.println("i is :"+i);
			System.out.println("pat[i] is :"+temp);
			TF[i][temp] = i + 1;

			lps = TF[lps][temp];
			System.out.println("lps is: "+lps);
		}
		print2DArray(TF);
		
	}

	/* Prints all occurrences of pat in txt */
	public static void search(char[] pat, char[] txt) {
		int M = pat.length;
		int N = txt.length;

		int[][] TF = new int[M + 1][NO_OF_CHARS];

		//computeTransFun(pat, M, TF);
		//System.out.println(Arrays.toString(TF));

		// process text over FA.
		int i, j = 0;
		for (i = 0; i < N; i++) {
			j = TF[j][txt[i]];
			if (j == M) {
				System.out.printf("\n pattern found at index %d", i - M + 1);
			}
		}
	}
	
	public static void print2DArray(int[][] arr){
		for (int i=0;i< arr.length;i++){
			System.out.println();
			for(int j= 0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
		}
		System.out.println();
		
	}

}
