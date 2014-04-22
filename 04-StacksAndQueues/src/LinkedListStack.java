public class LinkedListStack {

	StackNode top;

	public LinkedListStack() {
		top = null;
	}

	// Function to add an item to stack.
	public void push(int item) {
		StackNode node = new StackNode(item);
		// If stack is empty, then new node added is top
		if (top == null) {
			top = node;
			return;
		}
		node.next = top;
		top = node;
	}

	// Function to remove an item from stack. It decreases top by 1
	public int pop() {
		// If stack is empty, return MIN.
		if (top == null)
			return Integer.MIN_VALUE;

		int temp = top.key;
		top = top.next;
		return temp;
	}

	// Function to get top item from stack
	public int peek() {
		// If stack is empty, return MIN.
		if (top == null)
			return Integer.MIN_VALUE;

		return this.top.key;
	}

	// Stack is empty when top is equal to null
	public boolean isEmpty() {
		return this.top == null;
	}

	class StackNode {
		int key;
		StackNode next;

		public StackNode(int data) {
			this.key = data;
			this.next = null;
		}

	}

}