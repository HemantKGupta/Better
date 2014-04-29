import java.util.Deque;
import java.util.LinkedList;

public class PairSumBST {

	public static void main(String[] args) {
		BNode root = new BNode(5);
		root.left = new BNode(3);
		root.right = new BNode(9);
		root.left.left = new BNode(1);
		root.left.right = new BNode(4);
		root.right.left = new BNode(6);
		System.out.println(isPairPresent(root, 7));

	}

	// Returns true if a pair with target sum exists in BST, otherwise false
	public static boolean isPairPresent(BNode root, int target) {
		// s1 is used for normal inorder traversal
		// and s2 is used for reverse inorder traversal
		Deque<BNode> s1 = new LinkedList<BNode>();
		Deque<BNode> s2 = new LinkedList<BNode>();

		// done1, val1 and curr1 are used for normal inorder traversal using s1
		// done2, val2 and curr2 are used for reverse inorder traversal using s2
		boolean done1 = false, done2 = false;
		int val1 = 0, val2 = 0;
		BNode curr1 = root, curr2 = root;

		// The loop will break when we either find a pair or one of the two
		// traversals is complete
		while (true) {

			while (done1 == false) {
				if (curr1 != null) {
					s1.push(curr1);
					curr1 = curr1.left;
				} else {
					if (s1.isEmpty())
						done1 = true;
					else {
						curr1 = s1.pop();
						val1 = curr1.data;
						curr1 = curr1.right;
						done1 = true;
					}
				}
			}

			// Find next node in REVERSE Inorder traversal
			// right subtree is traversed before left subtree
			while (done2 == false) {
				if (curr2 != null) {
					s2.push(curr2);
					curr2 = curr2.right;
				} else {
					if (s2.isEmpty())
						done2 = true;
					else {
						curr2 = s2.pop();
						val2 = curr2.data;
						curr2 = curr2.left;
						done2 = true;
					}
				}
			}

			// If we find a pair, then print the pair and return. The first
			if ((val1 != val2) && (val1 + val2) == target) {
				System.out.printf("\n Pair Found: %d + %d = %d\n", val1, val2,
						target);
				return true;
			}

			// If sum of current values is smaller,
			else if ((val1 + val2) < target)
				done1 = false;

			// If sum of current values is greater
			else if ((val1 + val2) > target)
				done2 = false;

			// If any of the inorder traversals is over
			if (val1 >= val2)
				return false;
		}
	}

}
