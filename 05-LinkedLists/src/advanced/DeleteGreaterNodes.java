package advanced;

public class DeleteGreaterNodes {

	public static void main(String[] args) {
		Node root = new Node(12);
		root.next = new Node(15);
		root.next.next = new Node(10);
		root.next.next.next = new Node(11);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		root.next.next.next.next.next.next = new Node(2);
		root.next.next.next.next.next.next.next = new Node(3);
		System.out.println(root);
		System.out.println(deleteGreaterNodes(root));
	}

	// Deletes nodes which have greater value node on right side
	public static Node deleteGreaterNodes(Node head_ref) {
		Node root = reverseList(head_ref);
		deleteLesserNodes(root);
		return reverseList(root);
	}

	//Deletes nodes which have lesser value node(s) on left side
	public static void deleteLesserNodes(Node head) {
		Node current = head;
		Node maxnode = head;
		Node temp;

		while (current != null && current.next != null) {
			/* If current is smaller than max, then delete current */
			if (current.next.data < maxnode.data) {
				temp = current.next;
				current.next = temp.next;
				temp = null;
			}
			// update max
			else {
				current = current.next;
				maxnode = current;
			}

		}
	}

	public static Node reverseList(Node headref) {
		Node current = headref;
		Node prev = null;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		headref = prev;
		return headref;
	}

}
