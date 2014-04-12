import java.math.BigInteger;

public class PermMissingElem {

	public static void main(String[] args) {
		int[] A = { 1,2};
		System.out.println(solution(A));
	}

	public static int solution2(int[] A) {
		long n = A.length;
		if (n == 0){
			return 1;
		}
		if (n==1){
			if(A[0]== 1)
				return 2;
			else if (A[0]==2)
				return 1;
		}
		long requiredSum = (n + 1) * (n + 2) / 2;
		long sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		return (int) (requiredSum - sum);

	}
	
	public static int solution(int[] A) {
		long n = A.length;
		if (n == 0){
			return 1;
		}
		if (n==1){
			if(A[0]== 1)
				return 2;
			else if (A[0]==2)
				return 1;
		}
		BigInteger nPlusOne = BigInteger.valueOf(n+1);
		BigInteger nPlusTwo = BigInteger.valueOf(n+2);
		BigInteger requiredSum = nPlusOne.multiply(nPlusTwo).divide(BigInteger.valueOf(2));
		System.out.println(requiredSum);
		BigInteger sum = BigInteger.valueOf(0);
		for (long i = 0; i < A.length; i++) {
			sum = sum.add(BigInteger.valueOf(A[(int)i]));
		}
		return requiredSum.subtract(sum).intValue();
	}

}