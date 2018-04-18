/**
 * 
 */
package com.codility.example.DataStructure;

import java.util.NoSuchElementException;

/**
 * @author romiljain
 * 
 * This program is implementation of Queue using LinkedList
 *
 */
public class QueueUsingLinkedList {

	private Node front = null;

	private Node rear = null;

	public void enqueue(int x) {
		Node node = new Node();
		node.setData(x);
		if (front == null && rear == null) {
			front = node;
		} else {
			rear.setLink(node);
		}
		rear = node;
	}

	/** Removes the element from in front of queue and returns that element. */
	public int dequeue() {
		if (empty() )
            throw new NoSuchElementException("Underflow Exception");
		int element = front.getData();
		front = front.getLink();
		 if (front == null)
	            rear = null;
		return element;
	}

	/** Get the front element. */
	public int peek() {
		return front.getData();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		if (front == null) {
			return true;
		}
		return false;
	}

}
