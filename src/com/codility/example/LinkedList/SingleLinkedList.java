/**
 * 
 */
package com.codility.example.LinkedList;

/**
 * @author romiljain
 * @param <T>
 *
 */
public class SingleLinkedList<T> {

	private Node<T> header = null;

	private Node<T> tail = null;

	private int size = 0;

	/**
	 * This method will add default head node to the LinkedList
	 * 
	 */
	public void addFirst(T element) {
		Node<T> node = new Node<T>(element);
		if (header == null && tail == null) {
			// If header and tail is null then this is the first element to be
			// added
			header = node;
			tail = node;
		} else {
			// Add element at Head
			node.setNext(header);
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
		if (header == null && tail == null) {
			// If header and tail is null then this is the first element to be
			// added
			header = node;
			tail = node;
		} else {
			// Add element at Tail
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
		} else if (index == size) {
			addLast(element);
		} else {
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
		Node<T> node = new Node<T>(element);
		if (header == null && tail == null) {
			// If header is null then This is the first element to be added
			header = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;

		}
		++size;
	}

	/**
	 * This method will remove default head node from the LinkedList
	 * 
	 */
	public void removeFirst() {
		if (size == 0) {
			System.out.println("List is Empty");
		} else {
			header = header.getNext();
		}
		--size;
	}

	/**
	 * This method will remove default head node from the LinkedList
	 * 
	 */
	public void removeLast() {
		if (size == 0) {
			System.out.println("List is Empty");
		} else {
			tail = null;
			tail = get(size - 2);
		}
		--size;
	}

	/**
	 * This method will remove element at index from the LinkedList
	 * 
	 */
	public void remove(int index) {
		if (size == 0) {
			System.out.println("List is Empty");
		} else {
			if (index == 0) {
				removeFirst();
			} else {
				Node<T> previousNode = get(index - 1);
				Node<T> nodeAtIndex = previousNode.getNext();
				previousNode.setNext(nodeAtIndex.getNext());
				nodeAtIndex = null;
				--size;
			}

		}
	}

	/**
	 * This method will remove element from the LinkedList
	 * 
	 */
	public void remove(T element) {
		if (size == 0) {
			System.out.println("List is Empty");
		} else {
			Node<T> previousNode = previousNode(element);
			if (previousNode == null) {
				// Node is header
				header = header.getNext();
			} else {
				Node<T> nodeAtIndex = previousNode.getNext();
				previousNode.setNext(nodeAtIndex.getNext());
				nodeAtIndex = null;
			}
			--size;
		}
	}

	public Node<T> get(int index) {
		Node<T> node = null;
		if (size == 0) {
			System.out.println("List is Empty");
		} else if (index < size && size > 0) {
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
			return null;
		} else {
			while(node!= null){
				if (element.equals(node.getNext().getElement())){
					return node;
				}
				node = node.getNext();
			}
		}
		return null;
	}

}
