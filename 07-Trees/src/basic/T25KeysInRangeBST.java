package basic;


public class T25KeysInRangeBST {

	public static void main(String[] args) {
		BNode root = new BNode(5);
		root.left = new BNode(3);
		root.right = new BNode(9);
		root.left.left = new BNode(1);
		root.left.right = new BNode(4);
		root.right.left = new BNode(6);
		printKeysInRange2(root, 4, 8);
	}

	public static void printKeysInRange1(BNode root, int small, int large) {
		if (root == null)
			return;
		if (root.data < small) {
			printKeysInRange1(root.right, small, large);
		}
		if (small < root.data && root.data < large) {
			System.out.println(root.data + " ");
			printKeysInRange1(root.left, small, large);
			printKeysInRange1(root.right, small, large);
		}
		if (root.data > large) {
			printKeysInRange1(root.left, small, large);
		}
	}

	public static void printKeysInRange2(BNode root, int small, int large) {
		if (root == null)
			return;
		if (root.data > small) {
			printKeysInRange2(root.left, small, large);
		}
		if (small < root.data && root.data < large) {
			System.out.println(root.data + " ");
		}
		if (root.data < large) {
			printKeysInRange2(root.right, small, large);
		}
	}

}
