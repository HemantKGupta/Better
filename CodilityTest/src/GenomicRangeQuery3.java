import java.util.Arrays;


public class GenomicRangeQuery3 {

	public static void main(String[] args) {
		String S = "GACACCATA";
		int[] P = {0, 0, 4, 7 };
		int[] Q = {8, 2, 5, 7 };
		System.out.println(Arrays.toString(solution(S, P, Q)));
	}
	
	public static int[] solution(String S, int[] P, int[] Q) {
		int n = S.length();
		int[][] count = new int[n][4];
		int[] result = new int[P.length];
		
		for (int i = 0; i < n; i++) {
			char val = S.charAt(i);
			switch (val) {	
				case 'A':
					count[i][0] =  1;
					break;
				case 'C':
					count[i][1] =  1;
					break;
				case 'G':
					count[i][2] = 1;
					break;
				case 'T':
					count[i][3] =  1;
					break;
		    }	
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				count[i][j] = count[i][j] +count[i-1][j];
			}
		}
		
		printMatrix(count);
		
		for (int i = 0; i < P.length; i++) {
			int start = P[i];
			int end = Q[i];
			
			for (int k=0; k < 4;k++){
				int lowerValue = 0;
				if (start != 0){
					lowerValue = count[start-1][k];
				}
				if (count[end][k]- lowerValue > 0){
					result[i] = k+1;
					break;
				}
				
			}
		}
		
		return result;
	}
	
	public static void printMatrix(int[][] count){
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[0].length; j++) {
				System.out.print(count[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	

}
