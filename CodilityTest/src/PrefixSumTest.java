import java.util.Arrays;


public class PrefixSumTest {

	public static void main(String[] args) {
		/*int [] a = {2,3,1,5,1,3,9};
		int n = a.length;
		int [] prefixSum = new int[n+1];
		prefixSum[0]= 0;
		for (int i = 0; i < n; i++) {
			prefixSum[i+1] = prefixSum[i]+a[i];
		}
		System.out.println(Arrays.toString(prefixSum));
		System.out.println(rangeSum(prefixSum,3,6));*/
		prefixMin();

	}
	
	public static int rangeSum(int[] prefixSum, int start, int end){
		return prefixSum[end]-prefixSum[start];
		
	}
	
	public static void prefixMin(){
		int [] a = {2,3,1,5,1,3,9};
		int n = a.length;
		int [] prefixMin = new int[n];
		prefixMin[0]= a[0];
		for (int i = 1; i < n; i++) {
			prefixMin[i] = Math.min(prefixMin[i-1],a[i]);
		}
		System.out.println(Arrays.toString(prefixMin));
	}

}