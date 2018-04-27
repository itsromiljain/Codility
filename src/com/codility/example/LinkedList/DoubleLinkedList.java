/**
 * 
 */
package com.codility.example.LinkedList;

/**
 * @author romiljain
 * @param <T>
 *
 */
public class DoubleLinkedList<T> {

	private Node<T> header = null;

	private Node<T> tail = null;

	private int size = 0;

	/**
	 * This method will add default head node to the LinkedList
	 * 
	 */
	public void addFirst(T element) {
		Node<T> node = new Node<T>(element);
		if (size == 0) {
			// element is added as header
			header = node;
			tail = node;
		} else {
			header.setPrevious(node);
			node.setNext(header);
			node.setPrevious(null);
			header = node;
		}
		++size;
	}

	/**
	 * This method will add node at last to the LinkedList
	 * 
	 */
	public void addLast(T element) {
		Node<T> node = new Node<T>(element);
		if (size == 0) {
			// element is added as header/tail
			header = node;
			tail = node;
		} else {
			node.setNext(null);
			node.setPrevious(tail);
			tail.setNext(node);
			tail = node;
		}
		++size;
	}

	/**
	 * This method will add node at index to the LinkedList
	 * 
	 */
	public void add(T element, int index) {
		Node<T> node = new Node<T>(element);
		if (index == 0) {
			addFirst(element);
		} else if(index == size) {
			addLast(element);
		} else {
			Node<T> nodeAtIndex = get(index);
			nodeAtIndex.getPrevious().setNext(node);
			node.setPrevious(nodeAtIndex.getPrevious());
			nodeAtIndex.setPrevious(node);
			node.setNext(nodeAtIndex);
			++size;
		}
	}

	/**
	 * This method will add node at last to the LinkedList
	 * 
	 */
	public void add(T element) {
		addLast(element);
	}

	/**
	 * This method will remove default head node from the LinkedList
	 * 
	 */
	public void removeFirst() {
		if (size != 0) {
			header = header.getNext();
			header.setPrevious(null);
			--size;
		}
	}

	/**
	 * This method will remove default head node from the LinkedList
	 * 
	 */
	public void removeLast() {
		if (size != 0) {
			tail = tail.getPrevious();
			tail.setNext(null);
			--size;
		}
	}

	/**
	 * This method will remove element at index from the LinkedList
	 * @throws Exception 
	 * 
	 */
	public void remove(int index) throws Exception {
		if (size != 0) {
			if (index == 0) {
				removeFirst();
			} else if (index == size - 1) {
				removeLast();
			} else {
				Node<T> nodeAtIndex = get(index);
				if(nodeAtIndex == null){
					throw new Exception();
				}
				nodeAtIndex.getPrevious().setNext(nodeAtIndex.getNext());
				nodeAtIndex.getNext().setPrevious(nodeAtIndex.getPrevious());
				nodeAtIndex = null;
				--size;
			}
		}
	}

	/**
	 * This method will remove element from the LinkedList
	 * @throws Exception 
	 * 
	 */
	public void remove(T element) throws Exception {
		if (size != 0) {
			if (element.equals(header.getElement())) {
				removeFirst();
			} else if (element.equals(tail.getElement())) {
				removeLast();
			} else {
				Node<T> node = get(element);
				if(node == null){
					throw new Exception();
				}
				node.getPrevious().setNext(node.getNext());
				node.getNext().setPrevious(node.getPrevious());
				node = null;
				--size;
			}
		}
	}

	public Node<T> get(int index) {
		Node<T> node = null;
		if (size != 0) {
			node = header;
			for (int i = 0; i < index; i++) {
				node = node.getNext();
			}
		}
		return node;
	}

	public int size() {
		return size;
	}

	private Node<T> get(T element) {
		Node<T> node = header;
		while(node != null){
			if (element.equals(node.getElement())) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}
}
