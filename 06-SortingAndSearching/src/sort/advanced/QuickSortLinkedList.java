package sort.advanced;

public class QuickSortLinkedList {

	public static void main(String[] args) {
		Node root = new Node(19);
		root.next = new Node(20);
		root.next.next = new Node(13);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(15);
		root.next.next.next.next.next = new Node(26);
		root.next.next.next.next.next.next = new Node(72);
		root.next.next.next.next.next.next.next = new Node(18);
		root.next.next.next.next.next.next.next.next = new Node(9);
		quickSort(root);
	}
	
	// Returns the last node of the list
	public static Node getTail(Node cur)
	{
	    while (cur != null && cur.next != null)
	        cur = cur.next;
	    return cur;
	}
	 
	// Partitions the list taking the last element as the pivot
	public static Node partition(Node head, Node end,
	                       Node newHead, Node newEnd)
	{
	    Node pivot = end;
	    Node prev = null, cur = head, tail = pivot;
	 
	    // During partition, both the head and end of the list might change
	    // which is updated in the newHead and newEnd variables
	    while (cur != pivot)
	    {
	        if (cur.data < pivot.data)
	        {
	            // First node that has a value less than the pivot - becomes
	            // the new head
	            if ((newHead) == null)
	                (newHead) = cur;
	 
	            prev = cur;  
	            cur = cur.next;
	        }
	        else // If cur node is greater than pivot
	        {
	            // Move cur node to next of tail, and change tail
	            if (prev!=null)
	                prev.next = cur.next;
	            Node tmp = cur.next;
	            cur.next = null;
	            tail.next = cur;
	            tail = cur;
	            cur = tmp;
	        }
	    }
	 
	    // If the pivot data is the smallest element in the current list,
	    // pivot becomes the head
	    if ((newHead) == null)
	        (newHead) = pivot;
	 
	    // Update newEnd to the current last node
	    (newEnd) = tail;
	 
	    // Return the pivot node
	    return pivot;
	}
	 
	 
	//here the sorting happens exclusive of the end node
	public static Node quickSortRecur(Node head, Node end)
	{
	    // base condition
	    if (head == null || head == end)
	        return head;
	 
	    Node  newHead = null, newEnd = null;
	 
	    // Partition the list, newHead and newEnd will be updated
	    // by the partition function
	    Node pivot = partition(head, end, newHead, newEnd);
	 
	    // If pivot is the smallest element - no need to recur for
	    // the left part.
	    if (newHead != pivot)
	    {
	        // Set the node before the pivot node as null
	        Node tmp = newHead;
	        while (tmp.next != pivot)
	            tmp = tmp.next;
	        tmp.next = null;
	 
	        // Recur for the list before pivot
	        newHead = quickSortRecur(newHead, tmp);
	 
	        // Change next of last node of the left half to pivot
	        tmp = getTail(newHead);
	        tmp.next =  pivot;
	    }
	 
	    // Recur for the list after the pivot element
	    pivot.next = quickSortRecur(pivot.next, newEnd);
	 
	    return newHead;
	}
	 
	// The main function for quick sort. This is a wrapper over recursive
	// function quickSortRecur()
	public static void quickSort(Node headRef)
	{
	    (headRef) = quickSortRecur(headRef, getTail(headRef));
	    System.out.println(headRef);
	    return;
	}
}
