public class NoOccuringOddNoTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int ar[] = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		System.out.println(getOddOccurrence(ar));
	}

	public static int getOddOccurrence(int[] ar) {
		int i;
		int res = 0;
		for (i = 0; i < ar.length; i++)
			res = res ^ ar[i];
		return res;
	}

}