package com.codility.example.DataStructure;

import java.util.Stack;

public class QueueUsingTwoStacks {
	
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	int front = 0;
	
	public QueueUsingTwoStacks() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	if (stack.isEmpty()){
    		front = x;
    	}
    	stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	while(!stack.isEmpty()){
    		stack2.push(stack.pop());
    	}
    	int top = stack2.isEmpty()? 0: stack2.pop();
    	front = stack2.isEmpty()? 0: stack2.peek();
    	while(!stack2.isEmpty()){
    		stack.push(stack2.pop());
    	}
        return top;
    }
    
    /** Get the front element. */
    public int peek() {
    	return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() ? true:false;
    }
}
