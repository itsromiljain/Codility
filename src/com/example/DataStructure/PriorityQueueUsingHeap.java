/**
 * 
 */
package com.example.DataStructure;

/**
 * @author romiljain
 *
 */
public class PriorityQueueUsingHeap {
	
	private int INITIAL_CAPACITY = 10;
	
	private int[] array;
	
	
	public PriorityQueueUsingHeap() {
		array = new int[INITIAL_CAPACITY];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public void insert(int element) {
		MaxHeap mxHeap = new MaxHeap();
		mxHeap.buildMaxHeap(add(element));
	}
	
	public int[] add(int newItem)
	{
	    int currentSize = array.length;
	    int newSize = currentSize + 1;
	    int[] tempArray = new int[ newSize ];
	    for (int i=0; i < currentSize; i++)
	    {
	        tempArray[i] = array [i];
	    }
	    tempArray[newSize- 1] = newItem;
	    return tempArray;   
	}
}
