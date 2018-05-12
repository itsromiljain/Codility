/**
 * 
 */
package com.example.LinkedList;

/**
 * @author romiljain
 * @param <T>
 *
 */
public class CircularLinkedList<T> {

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
			node.setNext(header);
			header = node;
			tail.setNext(header);
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
			// element is added as header
			header = node;
			tail = node;
		} else {
			node.setNext(header);
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
		if(index == 0){
			addFirst(element);
		}else {
			Node<T> previousNode = get(index - 1);
			node.setNext(previousNode.getNext());
			previousNode.setNext(node);
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
			tail.setNext(header);
			--size;
		}
	}

	/**
	 * This method will remove default head node from the LinkedList
	 * 
	 */
	public void removeLast() {
		if (size != 0) {
			tail = get(size - 2);
			tail.setNext(header);
			--size;
		}
	}

	/**
	 * This method will remove element at index from the LinkedList
	 * 
	 */
	public void remove(int index) {
		if (size != 0) {
			if (index == 0) {
				removeFirst();
			} else if (index == size - 1) {
				removeLast();
			} else {
				Node<T> previousNode = get(index - 1);
				Node<T> nodeAtIndex = previousNode.getNext();
				previousNode.setNext(nodeAtIndex.getNext());
				--size;
			}
		}
	}

	/**
	 * This method will remove element from the LinkedList
	 * 
	 */
	public void remove(T element) {
		if (size != 0) {
			if (element.equals(header.getElement())) {
				removeFirst();
			} else if (element.equals(tail.getElement())) {
				removeLast();
			} else {
				Node<T> previousNode = previousNode(element);
				Node<T> nodeAtIndex = previousNode.getNext();
				previousNode.setNext(nodeAtIndex.getNext());
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

	private Node<T> previousNode(T element) {
		Node<T> node = header;
		if (element.equals(node.getElement())) {
			return tail;
		} else {
			for (int i = 0; i < size - 1; i++) {
				if (element.equals(node.getNext().getElement())) {
					break;
				}
				node = node.getNext();
			}
			return node;
		}

	}

}
