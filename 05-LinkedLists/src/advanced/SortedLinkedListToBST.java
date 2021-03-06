package advanced;

public class SortedLinkedListToBST {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		root.next.next.next.next.next.next = new Node(7);

		printInorder(sortedListToBST(root));
	}

	public static Node h;

	public static BNode sortedListToBST(Node head) {
		if (head == null)
			return null;

		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}

	public static BNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
		
		int mid = (start + end) / 2;

		BNode left = sortedListToBST(start, mid - 1);
		BNode root = new BNode(h.data);
		h = h.next;
		BNode right = sortedListToBST(mid + 1, end);

		root.left = left;
		root.right = right;

		return root;
	}

	public static int getLength(Node head) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
