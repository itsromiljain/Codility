/**
 * 
 */
package com.example.DataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author romiljain
 * 
 *         Heap Implementation Using Array and MaxHeap Algorithm
 *
 */
public class HeapUsingArrayList {

	List<Integer> list;

	public HeapUsingArrayList() {
		list = new ArrayList<Integer>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HeapUsingArrayList heap = new HeapUsingArrayList();
		heap.insert(10);
		heap.insert(5);
		heap.insert(8);
		heap.insert(12);
		heap.insert(18);
		heap.insert(7);
		for (int elements : heap.list) {
			System.out.println(elements);
		}
		System.out.println("Deleted Element-->"+heap.delete());
		for (int elements : heap.list) {
			System.out.println(elements);
		}
	}

	public void insert(int element) {
		list.add(element);
		shiftUp();
	}

	public void shiftUp() {
		int index = list.size() - 1;
		while (index > 0) {
			int parentIndex = (index - 1) / 2;
			if (list.get(index) > list.get(parentIndex)) {
				// swap the elements
				int element = list.get(index);
				int parentElement = list.get(parentIndex);
				list.set(index, parentElement);
				list.set(parentIndex, element);
				index = parentIndex;
			} else {
				break;
			}
		}
	}

	public int delete() {
		int deletedElement = list.get(0);
		list.set(0, list.remove(list.size() - 1));
		shiftDown();
		return deletedElement;
	}

	public void shiftDown() {
		int index = 0;
		int size = list.size() - 1;
		while (index < size) {
			int leftIndex = 2 * index + 1;
			int rightIndex = 2 * index + 2;
			int highest = index;
			if (leftIndex <= size && list.get(leftIndex) > list.get(index)) {
				highest = leftIndex;
			}

			if (rightIndex <= size && list.get(rightIndex) > list.get(highest)) {
				highest = rightIndex;
			}

			if (highest != index) {
				// Swap Elements
				int parentElement = list.get(index);
				int highestElement = list.get(highest);

				list.set(highest, parentElement);
				list.set(index, highestElement);
				index = highest;
			}else {
				break;
			}
			
		}
	}
}
