/**
 * 
 */
package com.codility.example.DataStructure;

/**
 * @author romiljain
 * This is an Array Implementation of Stack
 *
 */
public class StackUsingArray {
	
	
	private int size;
	
	private int[] array;
	
	private int top;
	
	private int INITIAL_DEFAULT_CAPACITY = 10;
	
	public StackUsingArray() {
		// Default constructor;
		this.size = INITIAL_DEFAULT_CAPACITY;
		this.array = new int[INITIAL_DEFAULT_CAPACITY];
		this.top = 0;
	}
	
	public StackUsingArray (int size){
		this.size = size;
		this.array = new int[size];
		this.top = 0;
	}
	
	public void push(int element) {
		if(top == size){
			// stack is full
			System.out.println("Stack is Full");
		}else {
			array[top] = element;
			top = top+1;
		}
		
	}
	
	public int pop() {
		int element = 0;
		if(isEmpty()){
			// stack is empty
			System.out.println("Stack is Empty");
		}else {
			element = top();
			top = top-1;
		}
		return element;
	}
	
	
	public int top() {
		return array[top-1];
	}
	
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		return false;
	}
	
}
