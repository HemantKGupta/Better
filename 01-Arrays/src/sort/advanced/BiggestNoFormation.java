package sort.advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BiggestNoFormation {

	public static void main(String[] args) {
		int[] ar = { 54, 546, 548, 60 };
		List<MyInteger> list = new ArrayList<MyInteger>();
		list.add(new MyInteger(54));
		list.add(new MyInteger(546));
		list.add(new MyInteger(548));
		list.add(new MyInteger(60));
		Collections.sort(list);
		System.out.println(list);
		List<MyInteger> list2 = new ArrayList<MyInteger>();
		list2.add(new MyInteger(1));
		list2.add(new MyInteger(34));
		list2.add(new MyInteger(3));
		list2.add(new MyInteger(98));
		list2.add(new MyInteger(9));
		list2.add(new MyInteger(76));
		list2.add(new MyInteger(45));
		list2.add(new MyInteger(4));
		Collections.sort(list2);
		System.out.println(list2);

	}

}

class MyInteger implements Comparable<MyInteger> {
	int data;

	public MyInteger(int data) {
		this.data = data;
	}

	@Override
	public int compareTo(MyInteger o) {
		String first = Integer.toString(this.data) + Integer.toString(o.data);
		String second = Integer.toString(o.data) + Integer.toString(this.data);

		return Integer.parseInt(second) - Integer.parseInt(first);
	}

	@Override
	public String toString() {
		return Integer.toString(this.data);
	}

}