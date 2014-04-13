
public class MaxDoubleSliceSum2 {

	public static void main(String[] args) {
		int[] A = {3,2,6,-1, 4, 5, -1, 2};
		System.out.println(solution(A));

	}
	
	public static int solution(int[] A) {
		  int N = A.length;
		  int[] maxEndingArray = new int[N];
		  int[] macStartingArray = new int[N];

		  for(int i = 1; i < N-1; i++){
		    maxEndingArray[i] = Math.max(0,maxEndingArray[i-1] + A[i]);
		  }
		  
		  for(int i = N-2; i > 0; i--){
		    macStartingArray[i] = Math.max(0, macStartingArray[i+1]+A[i]);
		  }

		  int max = 0;

		  for(int i = 1; i < N-1; i++){
		    max = Math.max(max, maxEndingArray[i-1]+macStartingArray[i+1]);
		  }

		  return max;
		
	}
	

	
	public static int maxSlice(int[] A){
		
		int max_ending = 0;
		int max_slice = 0;
		for (int val : A) {
			max_ending = Math.max(0, max_ending + val);
			max_slice = Math.max(max_slice, max_ending);
		}	
		return max_slice;

	}

}
