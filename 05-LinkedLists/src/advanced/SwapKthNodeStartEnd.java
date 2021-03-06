package advanced;

public class SwapKthNodeStartEnd {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		root.next.next.next.next.next.next = new Node(7);
		root.next.next.next.next.next.next.next = new Node(8);
		root.next.next.next.next.next.next.next.next = new Node(9);
		swapKth(root, 3);
		System.out.println(root);
	}

	/* Function for swapping kth nodes from both ends of linked list */
	public static void swapKth(Node head_ref, int k) {
		int n = countNodes(head_ref);

		if (n < k)
			return;

		// If x (kth node from start) and y(kth node from end) are same
		if (2 * k - 1 == n)
			return;

		// Find the kth node and its prev from beginning of linked list
		Node x = head_ref;
		Node x_prev = null;
		for (int i = 1; i < k; i++) {
			x_prev = x;
			x = x.next;
		}

		// Find the kth node from end and its previous
		Node y = head_ref;
		Node y_prev = null;
		for (int i = 1; i < n - k + 1; i++) {
			y_prev = y;
			y = y.next;
		}

		// If x_prev exists, then new next of it will be y. Consider the case
		// when y.next is x, in this case, x_prev and y are same. So the
		// statement
		// "x_prev.next = y" creates a self loop. This self loop will be broken
		// when we change y.next.
		if (x_prev != null)
			x_prev.next = y;

		// Same thing applies to y_prev
		if (y_prev != null)
			y_prev.next = x;

		// Swap next pointers of x and y. These statements also break self
		// loop if x.next is y or y.next is x
		Node temp = x.next;
		x.next = y.next;
		y.next = temp;

		// Change head pointers when k is 1 or n
		if (k == 1)
			head_ref = y;
		if (k == n)
			head_ref = x;
	}

	public static int countNodes(Node s) {
		int count = 0;
		while (s != null) {
			count++;
			s = s.next;
		}
		return count;
	}

}
