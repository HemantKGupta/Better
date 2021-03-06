package basic;

public class BITB01BitUtility {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isBitSet(15, 3));
		System.out.println(setBit(15, 0));
		System.out.println(clearBitAtPosition(15, 0));
	}


	public static boolean isBitSet(int num, int position) {
		return (num & (1 << position)) != 0;
	}

	/**
	 * @param num input number
	 * @param position counted from lsb to rsb
	 * @return output number
	 */
	public static int setBit(int num, int position) {
		// mask will have 1 at position
		int mask = (1 << position);
		return num | mask ;
	}

	/**
	 *
	 * @param num input number
	 * @param position counted from lsb to rsb
	 * @return output number
	 */
	public static int clearBitAtPosition(int num, int position) {
		//mask will have 0 at the position
		int mask = ~(1 << position);
		return num & mask ;
	}

}
