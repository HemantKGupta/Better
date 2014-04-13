public class EquiLeader {

	public static void main(String[] args) {
		int[] A = { 4, 3, 4, 4, 4, 2 };
		// System.out.println(leader(B, 0,B.length-1));
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int noOfEquiLeaders = 0;
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
				size = 1;
			}
		}
		int counterLeader = 0;
		for (int i = 0; i < A.length; i++) {
			if (leader == A[i]) {
				counterLeader++;
			}
		}
		if (counterLeader <= len / 2) {
			return 0;
		}

		int leaderCountLeft = 0;
		for (int i = 0; i < len; i++) {
			if (A[i] == leader)
				leaderCountLeft++;
			int leaderCountRight = counterLeader - leaderCountLeft;
			if (leaderCountLeft > (i + 1) / 2
					&& leaderCountRight > (len - i - 1) / 2) {
				noOfEquiLeaders++;
			}
		}
		return noOfEquiLeaders;
	}

}
