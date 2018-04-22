/**
 * 
 */
package com.codility.example.DataStructure;

/**
 * @author romiljain
 *
 */
public class MaxHeap {

	// Heap helps in implementing Priority Queue.

	// consider an array as [3, 8, 5, 7, 10, 12, 6]
	
	// Time Complexity: O (N log N)
	public static void main(String args[]) {
		// int array[] = {1,4,3,7,8,9,10};
		//int array[] = { 3, 8, 5, 7, 10, 12, 6 };
		int array[] = {4, 5, 1, 6, 7, 3, 2};
		MaxHeap mxHeap = new MaxHeap();
		System.out.println(mxHeap.buildMaxHeap(array));
	}

	// Time Complexity: O ( N ).
	public int[] buildMaxHeap(int array[]) {

		// First find the size of Array. n is the length of an array
		int size = array.length;

		// We will iterate over the array from n/2 to 1 (bottom up)
		for (int index = (size / 2) - 1; index >= 0; index--) {
			maxHeapify(array, index, size);
		}

		return array;

	}

	// Time Complexity: O (log N) .
	public void maxHeapify(int array[], int index, int size) {

		int leftNodeIndex = 2 * index + 1;

		int rightNodeIndex = 2 * index + 2;

		int largestIndex = index;

		if (leftNodeIndex < size && array[leftNodeIndex] > array[index]) {
			largestIndex = leftNodeIndex;
		}

		if (rightNodeIndex <= size && array[rightNodeIndex] > array[largestIndex]) {
			largestIndex = rightNodeIndex;
		}

		// now if largest index is not same as index we should swap the elements
		// and call on tree nodes below it
		if (largestIndex != index) {
			// when we get the largestIndex we should swap the elements
			int temp = array[index];
			array[index] = array[largestIndex];
			array[largestIndex] = temp;
			maxHeapify(array, largestIndex, size);
		}

	}

}
