package basic;

import java.util.HashSet;

public class LL012DeleteDuplicateNodeOfUnsortedList {

	public static void main(String[] args) {

		Node root = new Node(5);
		Node n1 = new Node(4);
		root.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(4);
		n2.next = n3;
		Node n4 = new Node(1);
		n3.next = n4;
		//deleteDupsA(root);
		//deleteDupsB(root);
		deleteDupsC(root);
		printList(root);

	}

	// Find duplicates by checking in set
	public static void deleteDupsA(Node n) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}

	// reomve dups from future nodes
	public static void deleteDupsB(Node head) {
		if (head == null)
			return;

		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	// remove dups from past nodes
	public static void deleteDupsC(Node head) {
		if (head == null)
			return;
		Node previous = head;
		Node current = previous.next;
		while (current != null) {
			// Look backwards for dups, and remove any that you see.
			Node runner = head;
			while (runner != current) {
				if (runner.data == current.data) {
					Node tmp = current.next;
					previous.next = tmp;
					current = tmp;
					break;
				}
				runner = runner.next;
			}
			if (runner == current) {
				previous = current;
				current = current.next;
			}
		}
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
