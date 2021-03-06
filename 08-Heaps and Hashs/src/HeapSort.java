
public class HeapSort {

	public static void main(String[] args) {
		Integer[] ar = { 1, 2, 4, 8, 5, 6, 9 };
		System.out.println("Array before sort is:");
		show(ar);
		sort(ar);
		System.out.println("\nArray after sort is:");
		show(ar);

	}
	
	
	 public static void sort(Comparable[] pq) {
	        int N = pq.length;
	        for (int k = N/2; k >= 1; k--)
	            sink(pq, k, N);
	        while (N > 1) {
	            exch(pq, 1, N--);
	            sink(pq, 1, N);
	        }
	    }

	    private static void sink(Comparable[] pq, int k, int N) {
	        while (2*k <= N) {
	            int j = 2*k;
	            if (j < N && less(pq, j, j+1)) j++;
	            if (!less(pq, k, j)) break;
	            exch(pq, k, j);
	            k = j;
	        }
	    }

	
	    private static boolean less(Comparable[] pq, int i, int j) {
	        return pq[i-1].compareTo(pq[j-1]) < 0;
	    }

	    private static void exch(Object[] pq, int i, int j) {
	        Object swap = pq[i-1];
	        pq[i-1] = pq[j-1];
	        pq[j-1] = swap;
	    }

	    // is v < w ?
	    private static boolean less(Comparable v, Comparable w) {
	        return (v.compareTo(w) < 0);
	    }
	        


	    // print array to standard output
	    private static void show(Comparable[] a) {
	        for (int i = 0; i < a.length; i++) {
	            System.out.println(a[i]);
	        }
	    }

	  

}
