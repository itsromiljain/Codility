/**
 * 
 */
package com.example.DataStructure;

/**
 * @author romiljain
 *
 */
public class TestDataStructure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackUsingLinkedList stackArr = new StackUsingLinkedList();
		stackArr.push(10);
		stackArr.push(5);
		stackArr.push(1);
		stackArr.push(3);
		System.out.println(stackArr.pop());
		System.out.println(stackArr.top());
		System.out.println(stackArr.pop());
		System.out.println(stackArr.pop());
		System.out.println(stackArr.top());
		stackArr.push(8);
		stackArr.push(9);
		stackArr.push(7);
		stackArr.push(6);
		stackArr.push(5);
		stackArr.push(1);
		stackArr.push(3);
		stackArr.push(4);
		stackArr.push(2);
		System.out.println(stackArr.top());
		stackArr.push(11);
		QueueUsingLinkedList arr = new QueueUsingLinkedList();
		arr.enqueue(10);
		arr.enqueue(5);
		arr.enqueue(1);
		arr.enqueue(3);
		System.out.println(arr.peek());
		arr.dequeue();
		System.out.println(arr.peek());
		arr.dequeue();
		System.out.println(arr.peek());
		arr.dequeue();
		System.out.println(arr.peek());
		arr.dequeue();
	}
	

}
