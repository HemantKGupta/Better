package advanced;

public class TwoNonRepeating {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 7, 9, 11, 2, 3, 11 };
		int[] results = get2NonRepeatingNos(arr);
		System.out.println("Numbers are: " + results[0] + " and : "
				+ results[1]);

	}

	
	public static int[] get2NonRepeatingNos(int arr[]) {
		int xor = arr[0];
		int setBitNum;
		int n = arr.length;
		int[] result = new int[2];

		for (int i = 1; i < n; i++)
			xor ^= arr[i];

		/* Get the rightmost set bit number */
		setBitNum = xor & ~(xor - 1);

		/*
		 * Compare rightmost set bit and create two sets.
		 */
		for (int i = 0; i < n; i++) {
			if ((arr[i] & setBitNum) == setBitNum) {
				System.out.println(" in if for i : " + i);
				result[0] = result[0] ^ arr[i];

			} else {
				result[1] = result[1] ^ arr[i];
			}
		}
		return result;
	}

}
