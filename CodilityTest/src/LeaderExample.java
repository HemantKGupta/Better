public class LeaderExample {

	public static void main(String[] args) {
		int[] A = { 6, 8, 4, 6, 8, 6, 6 };
		System.out.println(leader(A));
	}

	public static int leader(int[] A) {
		int len = A.length;
		int size = 1;
		int leader = A[0];
		for (int i = 1; i < len; i++) {
			if (leader == A[i]) {
				size++;
			} else {
				size--;
			}
			if (size == 0) {
				leader = A[i];
				size=1;;
			}
		}
		int counterLeader = 0;
		for (int i = 0; i < A.length; i++) {
			if (leader == A[i]) {
				counterLeader++;
			}
		}
		if (counterLeader > len / 2) {
			return leader;
		}
		return -1;
	}

}