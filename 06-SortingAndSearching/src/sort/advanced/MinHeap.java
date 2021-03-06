package sort.advanced;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

	public List<Integer> heap ;
	public int heapsize ;

	public static void main(String[] args) {
		MinHeap minheap = new MinHeap();
		minheap.insert(10);
		minheap.insert(30);
		minheap.insert(20);
		System.out.println(minheap.top());
		minheap.delete();
		System.out.println(minheap.top());
		minheap.delete();
		System.out.println(minheap.top());
		minheap.delete();
		System.out.println(minheap.top());
		
	}
	
	public MinHeap(){
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

	public void heapify(int i) {
		int parent = parent(i);
		while (parent >= 0 && this.heap.get(parent) > this.heap.get(i)) {
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
