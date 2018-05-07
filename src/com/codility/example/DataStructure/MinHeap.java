/**
 * 
 */
package com.codility.example.DataStructure;

/**
 * @author romiljain
 *
 */
public class MinHeap {

	/**
	 * @param args
	 */
	// Time Complexity: O (N log N)
	public static void main(String[] args) {
		//int array[] = {10,8,9,7,4,1,3};
		int array[] = {4, 5, 1, 6, 7, 3, 2};
		//int array[] = {3, 8, 5, 7, 10, 12, 6};
		MinHeap minHeap = new MinHeap();
		for(int i=0; i<array.length; i++){
			System.out.println(minHeap.buildMinHeap(array)[i]);
		}
		
	}

	// Time Complexity: O ( N ).
	public int[] buildMinHeap(int array[]) {

		// First find the size of Array. n is the length of an array
		int size = array.length;

		// We will iterate over the array from n/2 to 1 (bottom up)
		for (int index = (size / 2) - 1; index >= 0; index--) {
			minHeapify(array, index, size);
		}

		return array;

	}

	// Time Complexity: O (log N) .
	public void minHeapify(int array[], int index, int size) {

		int leftNodeIndex = 2 * index + 1;

		int rightNodeIndex = 2 * index + 2;

		int smallestIndex = index;

		if (leftNodeIndex < size && array[leftNodeIndex] < array[index]) {
			smallestIndex = leftNodeIndex;
		}

		if (rightNodeIndex <= size && array[rightNodeIndex] < array[smallestIndex]) {
			smallestIndex = rightNodeIndex;
		}

		// now if smallest index is not same as index we should swap the elements
		// and call on tree nodes below it
		if (smallestIndex != index) {
			// when we get the smallestIndex we should swap the elements
			int temp = array[index];
			array[index] = array[smallestIndex];
			array[smallestIndex] = temp;
			minHeapify(array, smallestIndex, size);
		}

	}
}
