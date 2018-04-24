/**
 * 
 */
package com.codility.example.DataStructure;

/**
 * @author romiljain
 *
 */
public class Node {
	
	private int value;
	
	private Node link;
	
	private Node left, right;
	
	public Node(){
		this.value = 0;
		this.link = null;
		left = null;
		right = null;
	}
	
	public Node(int value){
		this.value = value;
		this.link = null;
		left = null;
		right = null;
	}
	
	public Node(int value, Node link){
		this.value = value;
		this.link = link;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
}
