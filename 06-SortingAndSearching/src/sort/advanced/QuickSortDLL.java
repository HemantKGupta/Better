package sort.advanced;

public class QuickSortDLL {

	public static void main(String[] args) {
		DNode root = new DNode(10);
		root.next = new DNode(2);
		root.next.next = new DNode(8);
		root.next.next.next = new DNode(4);
		root.next.next.next.next = new DNode(15);
		root.next.next.next.next.next = new DNode(6);
		root.next.next.next.next.next.next = new DNode(17);
		root.next.next.next.next.next.next.next = new DNode(11);
		root.next.next.next.next.next.next.next.next = new DNode(12);
		
		quickSort(root);
	}

	// Considers last element as pivot
	public static DNode partition(DNode l, DNode h) {
		// set pivot as h element
		int x = h.data;

		// similar to i = l-1 for array implementation
		DNode i = l.prev;

		// Similar to "for (int j = l; j <= h- 1; j++)"
		for (DNode j = l; j != h; j = j.next) {
			if (j.data <= x) {
				// Similar to i++ for array
				i = (i == null) ? l : i.next;

				swapData(i, j);
			}
		}
		i = (i == null) ? l : i.next; // Similar to i++
		swapData(i, h);
		return i;
	}

	/* A recursive implementation of quicksort for linked list */
	public static void _quickSort(DNode l, DNode h) {
		if (h != null && l != h && l != h.next) {
			DNode p = partition(l, h);
			System.out.println("partition node: "+p.data);
			_quickSort(l, p.prev);
			_quickSort(p.next, h);
		}
		System.out.println(l);
	}

	// The main function to sort a linked list. It mainly calls _quickSort()
	public static void quickSort(DNode head) {
		// Find last node
		DNode h = lastNode(head);
		System.out.println("last node"+h.data);
		// Call the recursive SRT06QuickSort
		_quickSort(head, h);
		
	}

	// A utility function to find last node of linked list
	public static DNode lastNode(DNode root) {
		while (root != null && root.next != null)
			root = root.next;
		return root;
	}

	public static void swapData(DNode a, DNode b) {
		int temp = a.data;
		a.data = b.data;
		b.data = temp;
	}

}
