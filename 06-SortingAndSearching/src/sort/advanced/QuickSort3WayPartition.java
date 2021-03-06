package sort.advanced;

public class QuickSort3WayPartition {

	public static void main(String[] args) {
		Integer[] ar = { 1, 2, 4, 8, 5, 6, 9 };
		System.out.println("Array before sort is:");
		printArray(ar);
		sort(ar);
		System.out.println("\nArray after sort is:");
		printArray(ar);
	}
	
	public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    // quicksort the subarray a[lo .. hi] using 3-way partitioning
    private static void sort(Comparable[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0)
            	exch(a, lt++, i++);
            else if (cmp > 0) 
            	exch(a, i, gt--);
            else              i++;
        }
        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]. 
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
    
    private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}
    
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	

	public static void printArray(Integer[] arr) {
		// System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}

	}


}
