
public class Dominator {

	public static void main(String[] args) {
		int[] A = { 6, 8, 4, 6, 8, 6, 6 };
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
		int len = A.length;
		if(len == 0){
			return -1;
		}else if(len==1){
			return 0;
		}
		int size = 1;
		int val = A[0];
		int result = 0;
		for (int i = 1; i < len; i++) {
			if (val == A[i]) {
				size++;
			} else {
				size--;
			}
			if (size == 0) {
				val = A[i];
				result = i;
				size++;
			}
		}
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (val == A[i]) {
				count++;
			}
		}
		if (count > len / 2) {
			return result;
		}
		return -1;  
    }
}