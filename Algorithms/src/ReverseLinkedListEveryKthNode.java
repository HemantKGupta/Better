
public class ReverseLinkedListEveryKthNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* Start with the empty list */
	    Node head = new Node(8);
	  
	     /* Created Linked list is 1->2->3->4->5->6->7->8 */
	     //head = push(head, 8);
	     head = push(head, 7);
	     head = push(head, 6);
	     head =push(head, 5);
	     head =push(head, 4);
	     head =push(head, 3);
	     head =push(head, 2);
	     head =push(head, 1); 
	     
	     System.out.println("The original list: ");
	     printList(head);
	     head = reverse(head, 3);
	     System.out.println("\nThe reverse list: ");
	     printList(head);
	}
	
	/* Reverses the linked list in groups of size k and returns the 
	   pointer to the new head node. */
	public static Node reverse (Node head, int k)
	{
	    Node current = head;
	    Node next = null;
	    Node prev = null;
	    int count = 0;   
	     
	    /*reverse first k nodes of the linked list */
	    while (current != null && count < k)
	    {
	       next  = current.next;
	       current.next = prev;
	       prev = current;
	       current = next;
	       count++;
	    }
	     
	    /* next is now a pointer to (k+1)th node 
	       Recursively call for the list starting from current.
	       And make rest of the list as next of first node */
	    if(next !=  null)
	    {  head.next = reverse(next, k); }
	 
	    /* prev is new head of the input list */
	    return prev;
	}
	
	
	
	/* UTILITY FUNCTIONS */
	/* Function to push a node */
	public static Node  push(Node head, int new_data)
	{
	    /* allocate node */
	    Node new_node = new Node();
	 
	    /* put in the data  */
	    new_node.data  = new_data;
	 
	    /* link the old list off the new node */
	    new_node.next = head;    
	 
	    /* move the head to point to the new node */
	    head = new_node;
	    
	    return head;
	}
	
	/* Function to print linked list */
	public static void printList(Node node)
	{
	    while(node != null)
	    {
	        System.out.print(node.data +" ");
	        node = node.next;
	    }
	} 

}

class Node{
	
	int data;
	Node next;
	
	Node(int data){
		this.data= data;
		this.next=null;
	}
	
	Node(){
	}
}
