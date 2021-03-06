package advanced;

public class B023SwapBitRange {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(28345));
		System.out.println(Integer.toBinaryString(swapBits(28345, 0, 3, 2)));

	}
    // Swap a range of n bits in x from start position p1 with start position p2
	public static int swapBits(int x, int p1, int p2, int n) {
		/* Move all bits of first set to rightmost side */
		int set1 = (x >> p1) & ((1 << n) - 1);

		/* Moce all bits of second set to rightmost side */
		int set2 = (x >> p2) & ((1 << n) - 1);

		/* XOR the two sets */
		int xor = (set1 ^ set2);

		/* Put the xor bits back to their original positions */
		xor = (xor << p1) | (xor << p2);

		/*
		 * XOR the 'xor' with the original number so that the two sets are
		 * swapped
		 */
		int result = x ^ xor;

		return result;
	}

}
