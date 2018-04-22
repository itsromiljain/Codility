/**
 * 
 */
package com.codility.example.DataStructure;

/**
 * @author romiljain
 *
 */
public class BinarySearchTree {
	
	public static void main(String args[]) {
		// int array[] = {1,4,3,7,8,9,10};
		//int array[] = { 3, 8, 5, 7, 10, 12, 6 };
		int array[] = {1,2,3,4,5,6,7};
		int length = array.length;
		BinarySearchTree bst = new BinarySearchTree();
		Node node = bst.sortedArrayToBST(array, 0, length-1);
		System.out.println("Preorder traversal of constructed BST");
		bst.preOrder(node);
	}
	
	public Node sortedArrayToBST(int arr[], int start, int end){
		
		if(start>end) {
			return null;
		}
		
		int midIndex = (start+end)/2;
		
		Node rootNode = new Node(arr[midIndex]);
		
		rootNode.setLeft(sortedArrayToBST(arr, start, midIndex-1));
		
		rootNode.setRight(sortedArrayToBST(arr, midIndex+1, end));
		
		return rootNode;
	}
	
	/* A utility function to print preorder traversal of BST */
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

}
