package sort.advanced;

import java.util.Arrays;


public class MyHeapSort {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 4, 8, 5, 6, 9 };
		sort(ar);
		System.out.println(Arrays.toString(ar));

	}
	
	public static void sort(int[] arr){
		int heapsize = arr.length;
		
        for (int k = heapsize/2; k >= 0; k--)
            sink(arr, k, heapsize);
        
        
        int index = heapsize-1;
        while (index > 1) {
            swap(arr, 0, index);
            index--;
            sink(arr, 0, index);
        }
	}
	
	public static void sink(int[] arr, int i, int heapsize){
		if(heapsize == 1)
			return;
		int left = 2*i+1;
		int right = 2*i+2;
		int largest = i;
		
		if(left < heapsize && arr[left] > arr[i])
			largest = left;
		
		if(right < heapsize && arr[right] > arr[largest])
			largest = right;
		
		if(largest!=i){
			swap(arr, i, largest);
			sink(arr, largest, heapsize);
		}
		
		
	}
	
	public static void swap(int[] arr, int i, int j){
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp; 
	}
	

}
