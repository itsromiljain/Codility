/**
 * 
 */
package com.codility.example.DataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author romiljain
 * 
 * This program is implementation of Stack using 2 Queues
 *
 */
public class StackUsingTwoQueues {
	
	Queue<Integer> queue = new LinkedList<Integer>();
	
	Queue<Integer> queue2 = new LinkedList<Integer>();
	
	int top = 0;
	
	public StackUsingTwoQueues(){
		//default constructor
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue.add(x);
		top = x;
	}
	
	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		 int size = queue.size();
		 for (int i=1; i< size; i++){
			 top = queue.remove();
			 queue2.add(top);
		 }
		 int popElement = 0;
		 if(!queue.isEmpty()){
			 popElement =  queue.remove();
		 }
		 
		 Queue<Integer> tmp = queue;
		 queue = queue2;
		 queue2 = tmp;
		 return popElement;
	}
	
	/** Get the top element. */
    public int top() {
		 return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	if (queue.isEmpty())
    		return true;
    	else
    		return false;
    }
	
}
