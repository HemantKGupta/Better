
public class MinAvgTwoSlice2 {

	public static void main(String[] args) {
		int[] ar = { 4, 2, 2, 5,  1,  1,  8    };
		System.out.println(solution(ar));
	}
	
	public static int solution(int[] A){
		int N = A.length;
		double minAvg = (A[0]+A[1])/2;
		int minAvgStart = 0;
		
		for (int i=0; i < N-2;i++){
			double currAvg = (A[i]+ A[i+1])/2.0;
			if (minAvg > currAvg ){
				minAvg = currAvg;
				minAvgStart = i;
			}	
		
			currAvg = (A[i]+ A[i+1]+A[i+2])/3.0;
			if (minAvg > currAvg ){
				minAvg = currAvg;
				minAvgStart = i;
			}	
		}
		
		double currAvg = (A[N-2]+ A[N-1])/2.0;
		if (minAvg > currAvg ){
				minAvg = currAvg;
				minAvgStart = N-2;
		}
		
		return minAvgStart;
		
	}

}
