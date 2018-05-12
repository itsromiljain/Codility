/**
 * 
 */
package com.example.DataStructure;

/**
 * @author romiljain
 *
 *This program is implementation of Stack using LinkedList
 *
 */
public class StackUsingLinkedList {

	private int size;

	private Node top;

	public StackUsingLinkedList() {
		// Default constructor;
		top = null;
		size = 0;
	}

	public void push(int element) {
		Node node = new Node(element, null);
		if (null == top) {
			top = node;
		} else {
			node.setLink(top);
			top = node;
		}
		size++;
	}

	public int pop() {
		int data = 0;
		if (isEmpty()) {
			// stack is empty
			System.out.println("Stack is Empty");
		} else {
			data = top.getValue();
			Node node = top.getLink();
			top = node;
			size--;
		}

		return data;
	}

	public int top() {
		return top.getValue();
	}

	public boolean isEmpty() {
		return top == null;
	}
	
	public int size(){
		return size;
	}

}
