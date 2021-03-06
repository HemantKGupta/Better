package basic;


public class T12BBSTTest {

	public static void main(String[] args) {
		
		BNode root = new BNode(5);
		root.left = new BNode(3);
		root.right = new BNode(9);
		root.left.left = new BNode(1);
		root.left.right = new BNode(4);
		root.right.left = new BNode(6);
		System.out.println(checkBST(root));
	}

	public static Integer last_printed = null;

	public static boolean checkBST(BNode n) {
		
		//base case
		if (n == null) {
			return true;
		}

		// Check  recurse left
		if (!checkBST(n.left)) {
			return false;
		}

		// Check if current is less then previous
		if (last_printed != null && n.data <= last_printed) {
			return false;
		}
		last_printed = n.data;

		// Check  recurse right
		if (!checkBST(n.right)) {
			return false;
		}
		return true;
	}

}
