/**
 * 
 */
package com.codility.example.DataStructure;

/**
 * @author romiljain This program will sort the array in ascending order using
 *         MaxHeap. Time Complexity O(N logN)
 *
 */
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();
		int array[] = { 4,10,3,8,6,5,12 };
		heapSort.heapSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	// Time Complexity: O (N log N)
	public void heapSort(int array[]) {

		int length = array.length;

		int heap_size = length - 1;

		MaxHeap maxHeap = new MaxHeap();
		
		//Calling buildMaxHeap to sort the array as per MaxHeap
		maxHeap.buildMaxHeap(array);
		
		for (int i = length - 1; i >= 0; i--) {
			// swap array[i] with array[0] to keep the max element at the end
			// This will sort the array in ascending order
			swap(array, i);
			// reduce the size of the heap
			heap_size = heap_size - 1;
			// call the max heapify again
			maxHeap.maxHeapify(array, 0, heap_size);

		}
	}

	private void swap(int[] array, int i) {
		// Putting this condition to handle if array got already sorted after calling maxHeapify
		// Specifically when less no of elements remain to get sorted.
		if (array[0] > array[i]) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
		}
	}

}
