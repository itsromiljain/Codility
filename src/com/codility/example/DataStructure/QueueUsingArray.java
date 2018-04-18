/**
 * 
 */
package com.codility.example.DataStructure;

/**
 * @author romiljain
 * 
 * This program is implementation of Queue using Array
 *
 */
public class QueueUsingArray {

	int front = 0;
	
	int rare = 0;
	
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
		if(rare == size){
			// queue is full
			System.out.println("Queue is Full");
		}else {
			array[rare] = x;
			rare = rare+1;
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
			for(int i=1; i<size; i++){
				array[i-1] = array[i];
 			}
			rare = rare-1;
		}
		return element;
	}

	/** Get the front element. */
	public int peek() {
		return array[front];
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		if(front == rare){
			// queue is empty
			return true;
		}
		return false;
	}
}
