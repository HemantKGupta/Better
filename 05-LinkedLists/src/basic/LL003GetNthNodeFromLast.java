package basic;

public class LL003GetNthNodeFromLast {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node n1 = new Node(4);
		root.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(2);
		n2.next = n3;
		Node n4 = new Node(1);
		n3.next = n4;

		System.out.println(getNthNodeFromEnd(root, 2).data);
		System.out.println(getNthNodeFromEndUsingWrapper(root, 2,
				new IntWrapper()).data);
		getNthNodeValueFromEndRecr(root, 2);
	}

	public static Node getNthNodeFromEnd(Node root, int n) {

		Node tmp = root;
		Node ntmp = root;
		// Get hold to nth node from start
		for (int i = 1; i <= n; i++) {
			if (ntmp == null) {
				return null;
			}
			ntmp = ntmp.next;
		}
		// run previous and temp both
		while (ntmp != null) {
			ntmp = ntmp.next;
			tmp = tmp.next;
		}
		return tmp;
	}

	public static int getNthNodeValueFromEndRecr(Node root, int n) {
		// base case
		if (root == null)
			return 0;

		// get the return value of recursion
		int i = getNthNodeValueFromEndRecr(root.next, n) + 1;

		// compare to test
		if (i == n) {
			System.out.println("Data value is: " + root.data);
		}
		return i;
	}

	public static Node getNthNodeFromEndUsingWrapper(Node root, int n,
			IntWrapper iwrp) {

		if (root == null)
			return null;

		Node tmp = getNthNodeFromEndUsingWrapper(root.next, n, iwrp);

		iwrp.value = iwrp.value + 1;
		if (iwrp.value == n) {
			return root;
		}
		return tmp;
	}

static class IntWrapper {
	public int value = 0;
}
}

