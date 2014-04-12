import java.util.Arrays;


public class MaxCounters {

	public static void main(String[] args) {
		int[] A = {1,2,4,1,4};
		System.out.println(Arrays.toString(solution(3,A)));
	}
	
	public static int[] solution(int N, int[] A) {
		int[] counters = new int[N];
		int currentMax = 0;
		int currentMin = 0;
		for (int val : A) {
			if (val <= N){
				if (counters[val-1] <= currentMin){
					counters[val-1] = currentMin+1;
				}else{
					counters[val-1]++;
				}
				if(counters[val-1] > currentMax){
					currentMax = counters[val-1];
				}
			}else if (val == N+1){
				currentMin = currentMax;		
			}
		}
		for (int i = 0; i < counters.length; i++) {
			if(counters[i] < currentMin){
				counters[i] = currentMin;
			}
		}
		
		return counters;
    }
	private static int getMaxCounter(int[] counters){
		int max = 0;
		for (int value : counters) {
			if(max < value){
				max= value;
			}
		}
		return max;
	}
	
	private static int getMaxCounter2(int[] counters){
		int len = counters.length;
		int[] copy = Arrays.copyOf(counters,len);
		Arrays.sort(copy);
		return copy[len-1];
	}

}
