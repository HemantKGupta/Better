package sort.basic;

import java.util.Arrays;

public class SRT06QuickSort {

	public static void main(String[] args) {
		Integer[] ar = { 1, 2, 4, 8, 5, 6, 9 };
        System.out.println(Arrays.toString(ar));
        sort(ar);
        System.out.println(Arrays.toString(ar));
	}
	
	public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    // partition the subarray a[lo .. hi] by returning an index j
    // so that a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        //Get right place for lo
        Comparable v = a[lo];
        while (true) { 
            while (less(a[++i], v))
            	if (i == hi) break;
            while (less(v, a[--j]))
            	if (j == lo) break;// redundant   
            if (i >= j) break;
            exch(a, i, j);
        }
        // put v = a[j] into position
        exch(a, lo, j);
        return j;
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
