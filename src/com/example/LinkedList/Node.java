/**
 * 
 */
package com.example.LinkedList;

/**
 * @author romiljain
 *
 */
public class Node<T> implements Comparable<T> {
	
	private T element;
	
	private Node<T> next;
	
	private Node<T> previous;
	
	public Node(){
		// public constructor
		this.next = null;
		this.previous = null;
	}
	
	public Node(T element) {
		this.element = element;
		this.next = null;
		this.previous = null;
	}
	
	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	@Override
	public int compareTo(T o) {
		if (this.element == o){
			return 0;
		}
		return 1;
	}

}
