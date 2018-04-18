/**
 * 
 */
package com.codility.example.DataStructure;

/**
 * @author romiljain
 *
 */
public class QueueUsingArray {

	int front = 0;
	
	int index = 0;
	
	private int size;

	private int[] array;

	private int INITIAL_DEFAULT_CAPACITY = 10;
	
	public QueueUsingArray () {
		this.size = INITIAL_DEFAULT_CAPACITY;
		this.array = new int[INITIAL_DEFAULT_CAPACITY];
	}
	
	public QueueUsingArray (int size) {
		this.size = size;
		this.array = new int[size];
	}

	public void enqueue(int x) {
		if(index == size){
			// queue is full
			System.out.println("Queue is Full");
		}else {
			array[index] = x;
			index = index+1;
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int dequeue() {
		int element = 0;
		if(empty()){
			// queue is empty
			System.out.println("Queue is Empty");
		}else {
			element = array[front];
			// resize array
			int[] tempArray = new int[size];
			for(int i=0; i<size-1; i++){
				tempArray[i] = array[i+1];
 			}
			array = tempArray;
			index = index-1;
		}
		return element;
	}

	/** Get the front element. */
	public int peek() {
		return array[front];
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		if(front == index){
			// queue is empty
			return true;
		}
		return false;
	}
}
