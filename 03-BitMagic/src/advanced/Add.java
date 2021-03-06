package advanced;

public class Add {

	public static void main(String[] args) {
        int x = -8;
        System.out.println(x<<1);
        System.out.println(x>>1);
       // System.out.println(add(45, 32));
		//System.out.println(addRecr(45, 32));
	}

	public static int add(int x, int y) {
		// Iterate till there is no carry
		while (y != 0) {
			// carry now contains common set bits of x and y
			int carry = x & y;

			// Sum of bits of x and y where at least one of the bits is not set
			x = x ^ y;

			// Carry is shifted by one so that adding it to x gives the required
			// sum
			y = carry << 1;
		}
		return x;
	}

	public static int addRecr(int x, int y) {
		if (y == 0)
			return x;
		else
			return addRecr(x ^ y, (x & y) << 1);
	}

}
