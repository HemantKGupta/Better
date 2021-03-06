package sort.advanced;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

	public List<Integer> heap ;
	public int heapsize ;

	public static void main(String[] args) {
		MaxHeap maxheap = new MaxHeap();
		maxheap.insert(40);
		maxheap.insert(30);
		maxheap.insert(50);
		maxheap.insert(50);
		maxheap.insert(40);
		maxheap.insert(80);
		maxheap.insert(60);
		maxheap.sort();
		System.out.println(maxheap.heap);
		/*System.out.println(maxheap.top());
		maxheap.delete();
		System.out.println(maxheap.top());
		maxheap.delete();
		System.out.println(maxheap.top());
		maxheap.delete();
		System.out.println(maxheap.top());*/
		
	}
	
	public MaxHeap(){
		heap = new ArrayList<Integer>();
		heapsize = -1;
	}

	public int left(int i) {
		return 2 * i + 1;
	}

	public int right(int i) {
		return 2 * i + 2;
	}

	public int parent(int i) {

		if (i <= 0) {
			return -1;
		}
		return (i - 1) / 2;
	}

	public int top() {
		int max = -1;
		if (heapsize > -1) {
			max = heap.get(0);
		}
		return max;
	}

	public void insert(int i) {
	
		this.heapsize++;
		this.heap.add(heapsize, i);
		heapify(heapsize);

	}

	public int delete() {
		int result = -1;
		if (heapsize > -1) {
			result = this.heap.get(0);
			exchange(0, this.heapsize);
			this.heapsize--;
			heapify(parent(this.heapsize + 1));
		}
		return result;

	}
	
	public void sort(){
		int index = heapsize;
		for (int i=0; i < index; i++){
			heap.set(index-i, delete());
		}
	}

	public void heapify(int i) {
		int parent = parent(i);
		while (parent >= 0 && this.heap.get(parent) < this.heap.get(i)) {
			exchange(parent, i);
			heapify(parent);
		}

	}

	public void exchange(int i, int j) {
		int temp = this.heap.get(i);
		this.heap.set(i, this.heap.get(j));
		this.heap.set(j, temp);
	}

}
