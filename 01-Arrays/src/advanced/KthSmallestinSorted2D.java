package advanced;

public class KthSmallestinSorted2D {

	public static void main(String[] args) {
		int mat[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {25, 29, 37, 48},
                {32, 33, 39, 50} };
		System.out.println(kthSmallest(mat,4, 3));

	}
	public static void swap(HeapNode one, HeapNode other){
		HeapNode temp = one;
		one = other;
		other = temp; 
	}
	
	// This function returns kth smallest element in a 2D array mat[][]
	public static int kthSmallest(int mat[][], int n, int k)
	{
	    // k must be greater than 0 and smaller than n*n
	    if (k <= 0 || k > n*n)
	       return Integer.MAX_VALUE;
	 
	    // Create a min heap of elements from first row of 2D array
	    HeapNode[] harr = new HeapNode[n];
	    
	    for (int i = 0; i < n; i++)
	        harr[i] =  new HeapNode(mat[0][i], 0, i);
	    
	    buildHeap(harr, n);
	 
	    HeapNode hr = null;
	    for (int i = 0; i < k; i++)
	    {
	       // Get current heap root
	       hr = harr[0];
	 
	       // Get next value from column of root's value. If the
	       // value stored at root was last value in its column,
	       // then assign INFINITE as next value
	       int nextval = (hr.r < (n-1))? mat[hr.r + 1][hr.c]: Integer.MAX_VALUE;
	 
	       // Update heap root with next value
	       harr[0] =  new HeapNode(nextval, (hr.r) + 1, hr.c);
	 
	       // Heapify root
	       minHeapify(harr, 0, n);
	    }
	 
	    // Return the value at last extracted root
	    return hr.val;
	}
	
	
	public static void minHeapify(HeapNode harr[], int i, int heap_size)
	{
	    int l = i*2 + 1;
	    int r = i*2 + 2;
	    int smallest = i;
	    if (l < heap_size && harr[l].val < harr[i].val)
	        smallest = l;
	    if (r < heap_size && harr[r].val < harr[smallest].val)
	        smallest = r;
	    if (smallest != i)
	    {
	        swap(harr[i], harr[smallest]);
	        minHeapify(harr, smallest, heap_size);
	    }
	}
	 
	// A utility function to convert harr[] to a max heap
	public static void buildHeap(HeapNode harr[], int n)
	{
	    int i = (n - 1)/2;
	    while (i >= 0)
	    {
	        minHeapify(harr, i, n);
	        i--;
	    }
	}

	static class HeapNode {
		int val;  // value to be stored
		int r;    // Row number of value in 2D array
		int c;    // Column number of value in 2D array

		public HeapNode(int val, int r, int c) {
			this.val = val;
			this.r = r;
			this.c = c;
		}


	}

}
