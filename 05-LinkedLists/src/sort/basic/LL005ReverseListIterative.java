package sort.basic;

public class LL005ReverseListIterative {

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

		printList(root);
		root = reverse(root);
		printList(root);
	}

	public static Node reverse(Node head) {
		if (head == null)
			return head;

		Node current = head;
		Node previous = null;

		while (current != null) {
			Node nextNode = current.next;

			current.next = previous;
			previous = current;
			current = nextNode;
		}

		head = previous;
		return head;
	}

	public static void printList(Node root) {
		Node tmp = root;
		System.out.println("The list is: ");
		while (tmp != null) {
			System.out.print(tmp.data + ", ");
			tmp = tmp.next;
		}
		System.out.print("null\n");

	}

}
