/**
 * 
 */
package com.codility.example.DataStructure;

/**
 * @author romiljain
 *
 */
public class BinarySearchTreeImp {

	private Node rootNode;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTreeImp bst = new BinarySearchTreeImp();
		bst.insert(10);
		bst.insert(6);
		bst.insert(4);
		bst.insert(8);
		bst.insert(3);
		bst.insert(5);
		bst.insert(8);
		bst.insert(7);
		bst.insert(9);
		bst.insert(15);
		bst.insert(12);
		bst.insert(18);
		bst.preOrder(bst.rootNode);
		bst.delete(6);
		System.out.println("");
		bst.preOrder(bst.rootNode);
	}

	/*
	 * Insertion
	 */
	public Node insert(int value) {
		rootNode = insertRecursive(rootNode, value);
		return rootNode;
	}

	private Node insertRecursive(Node node, int value) {

		if (node == null) {
			node = new Node(value);
		}

		if (value < node.getValue()) {
			node.setLeft(insertRecursive(node.getLeft(), value));
		}

		if (value > node.getValue()) {
			node.setRight(insertRecursive(node.getRight(), value));
		}

		return node;
	}

	/*
	 * Find
	 */
	public boolean find(int value) {
		Node node = findNode(rootNode, value);
		if (node == null) {
			return false;
		}
		return true;
	}

	/* A utility function to traverse the BST */
	private Node findNode(Node node, int value) {
		if (node == null) {
			return null;
		}

		if (value == node.getValue()) {
			return node;
		}

		return value < node.getValue() ? findNode(node.getLeft(), value) : findNode(node.getRight(), value);
	}

	public void delete(int value) {
		// First find the node which suppose to be deleted
		Node node = findNode(rootNode, value);
		deleteNode(node);
	}

	private Node deleteNode(Node node) {
		if (node == null) {
			return null;
		} else {
			if (node.getLeft() == null && node.getRight() == null) {
				// delete this node directly
				return null;
			}

			// if Node has either left or right child
			if (node.getLeft() == null) {
				return node.getRight();
			}

			if (node.getRight() == null) {
				return node.getLeft();
			}

			// if node has both the child then find smallest value at the right
			// of the node and replace it with the node value
			// then delete that node from the right of the node (because of
			// duplicacy)
			int smallestValue = findSmallestValue(node.getRight());
			node.setValue(smallestValue);
			node.getRight().setLeft(deleteNode(findNode(node.getRight(), smallestValue)));
			return node;

		}
	}

	private int findSmallestValue(Node node) {
		return node.getLeft() == null ? node.getValue() : findSmallestValue(node.getLeft());
	}

	/* A utility function to print preorder traversal of BST */
	public void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getValue() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}

}
