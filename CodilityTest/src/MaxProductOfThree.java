import java.util.Arrays;


public class MaxProductOfThree {

	public static void main(String[] args) {
		int[] A = {-1, -3, -4, -5, -6, -8, -3, -9};
		System.out.println(solution(A));

	}
	public static int solution(int[] A) {
		 Arrays.sort(A);
		    System.out.println(Arrays.toString(A));    
		         int right = A[A.length-1] * A[A.length-2] * A[A.length-3];
		        int left = A[A.length-1] * A[0] * A[1];
	       
		        return left > right ? left : right;
    }

}