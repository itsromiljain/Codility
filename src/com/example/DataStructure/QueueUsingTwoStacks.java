package com.example.DataStructure;

import java.util.Stack;

public class QueueUsingTwoStacks {
	
	Stack<Integer> in = new Stack<Integer>();
	Stack<Integer> out = new Stack<Integer>();
	
	int front = 0;
	
	public QueueUsingTwoStacks() {
        // Default Constructor
    }
    
    /** Push element x to the back of queue. */
    public void enqueue(int x) {
    	if (in.isEmpty()){
    		front = x;
    	}
    	in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int dequeue() {
    	while(!in.isEmpty()){
    		out.push(in.pop());
    	}
    	int top = out.isEmpty()? 0: out.pop();
    	front = out.isEmpty()? 0: out.peek();
    	while(!out.isEmpty()){
    		in.push(out.pop());
    	}
        return top;
    }
    
    /** Get the front element. */
    public int peek() {
    	return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() ? true:false;
    }
}
