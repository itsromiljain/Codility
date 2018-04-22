/**
 * 
 */
package com.codility.example.DataStructure;

/**
 * @author romiljain
 *
 */
public class Node {
	
	private int data;
	
	private Node link;
	
	private Node left, right;
	
	public Node(){
		this.data = 0;
		this.link = null;
		left = null;
		right = null;
	}
	
	public Node(int data){
		this.data = data;
		this.link = null;
		left = null;
		right = null;
	}
	
	public Node(int data, Node link){
		this.data = data;
		this.link = link;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
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
