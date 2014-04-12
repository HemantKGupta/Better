import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class GenomicRangeQuery2 {
	
	public static Map<Character,Integer> map;
	
	static{		
		map = new HashMap<Character,Integer>();
		map.put('A', 1);
		map.put('C', 2);
		map.put('G', 3);
		map.put('T', 4);
	}

	public static void main(String[] args) {
		String S = "GACACCATA";
		int[] P = {0, 0, 4, 7 };
		int[] Q = {8, 2, 5, 7 };
		System.out.println(Arrays.toString(solution(S, P, Q)));
	}
	
	public static int[] solution(String S, int[] P, int[] Q) {
		int n = S.length();
				
		int [] prefixSum = new int[n+1];
		prefixSum[0]=0;
		for (int i = 0; i < n; i++){ 
			int val = getIntegerFromMap(S.charAt(i));
			System.out.println(" integer from map by char i: "+i+" is: "+val);
			prefixSum[i+1] = prefixSum[i]+ val;
			
		}
		System.out.println(Arrays.toString(prefixSum));
		
		int M = P.length;
		int[] result = new int[M];
		for (int i = 0; i < M; i++) {
			if (P[i] == Q[i]){
				System.out.println("P and Q are equal at i:"+ i);
				System.out.println("char is: "+S.charAt(P[i]));
				int val = getIntegerFromMap(S.charAt(P[i]));
				System.out.println("equal result: "+ val);
				result[i] = val;
			}else {
				result[i] = findMin(prefixSum,P[i],Q[i]);
			}
		}
		return result;

	}

	public static int findMin(int[] prefixSum, int i, int j) {
		int len = j-i+1;
		int sumInRange = prefixSum[j+1]-prefixSum[i];
		System.out.println("Inside min i: "+ i+" j: "+j+" and sumInRange: "+sumInRange);
		if (sumInRange == len*4){
			return 4;
		}else if (sumInRange < len*4 && sumInRange >= len*3){
			return 3;
		}else if (sumInRange < len*3 && sumInRange >= len*2){
			return 2;
		}else {
			return 1;
		}	
	}

	public static int getIntegerFromMap(char charAt) {
	    return map.get(charAt);
		
	}

}
