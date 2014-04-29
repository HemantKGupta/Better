
public class FlattenMultilevelList {

	public static void main(String[] args) {

	}
	
	/* The main function that flattens a multilevel linked list */
	public static void flattenList(MNode head)
	{
	    /*Base case*/
	    if (head == null)
	       return;
	 
	    MNode tmp;
	 
	    /* Find tail node of first level linked list */
	    MNode tail = head;
	    while (tail.next != null)
	        tail = tail.next;
	 
	    // One by one traverse through all nodes of first level
	    // linked list till we reach the tail node
	    MNode cur = head;
	    while (cur != tail)
	    {
	        // If current node has a child
	        if (cur.child != null)
	        {
	            // then append the child at the end of current list
	            tail.next = cur.child;
	 
	            // and update the tail to new last node
	            tmp = cur.child;
	            while (tmp.next!= null)
	                tmp = tmp.next;
	            tail = tmp;
	        }
	 
	        // Change current node
	        cur = cur.next;
	    }
	}

}
