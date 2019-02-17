/**
 * 
 */
package com.interview.amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.example.Graph.Node;

/*
 * *** Problem Statement ***
 * Given an array of n values,
 * a[v] = [2, 1, 2, 0, 3, 1, 2, 0, 1, ..., 1]
 * 
 * such that,
 * 
 * The number of items n, 10 < n < 1,000,000
 * a[0] != 0
 * a[n-1] != 0,
 * and for any n, 0 <= a[n] <= 100
 * for a given v, a[v] represents the possible moves in the array
 * i.e. if v = 4, a[4] = 3, so you may have either 1, 2 or 3 spaces
 * if a[v] = 0, you may not make any additional moves - considered failure
 * 
 * *** Challenge ***
 * .... come up with a solution to traverse from a[0] to a[n-1] with the smallest number of moves possible.
 * 
 */

/**
 * @author romiljain
 *
 */
public class JumpGame {

	Node[] nodes;

	public static void main(String[] args) {
		int[] a = { 1, 2, 1, 3, 4, 5, 2, 9, 10, 11, 1, 8};
		JumpGame jg = new JumpGame();
		// Calculating minimum no of moves via Dynamic Programming and Bottom Up approach
		jg.moves(a);
		// Calculating minimum no of moves via AdjacencyList and Graph Theory
		jg.createAdjacencyList(a);
		jg.calculateShortestDistance(0, a.length - 1);
	}

	// using Dynamic Programming
	public void moves(int[] a) {
		int[] array = new int[a.length];
		int count = recursion(0, a[0], array, a);
		System.out.println("No of Moves via Dynamic Programming--> " + count);
	}

	public int recursion(int index, int number, int[] array, int[] a) {
		if (index + number + 1 >= a.length) {
			// reached at the end
			array[index] = 1;
			return 1;
		}
		// using Dynamic Programming to return value
		if (array[index] != 0) {
			return array[index];
		} else {
			int count = Integer.MAX_VALUE;
			for (int j = 0; j < number; j++) {
				int currentCount = recursion(index + j + 1, a[index + j + 1], array, a);
				if (currentCount < count) {
					count = currentCount;
				}
			}
			count = count + 1;
			array[index] = count;
			return count;
		}
	}

	// First create adjacency list for this graph
	public void createAdjacencyList(int[] a) {
		nodes = new Node[a.length];
		for (int i = 0; i < a.length; i++) {
			Node node = new Node(i, String.valueOf(a[i]));
			nodes[i] = node;
		}

		for (int i = 0; i < a.length; i++) {
			Node vertexNode = nodes[i];
			Map<Node, Integer> adjacencyList = vertexNode.getAdjacencyList();
			for (int j = 0; j < a[i]; j++) {
				// Create Adjacency List
				if (i + j + 1 >= a.length) {
					// reached at the end
					adjacencyList.put(nodes[a.length - 1], 1);
				} else {
					adjacencyList.put(nodes[i + j + 1], 1);
				}
			}
			vertexNode.setAdjacencyList(adjacencyList);
		}
	}

	private void calculateShortestDistance(int sourceNodeIndex, int destinationNodeIndex) {
		// Get Source Node
		Node sourceNode = nodes[sourceNodeIndex];
		sourceNode.setDistance(0);

		// Create visitedNodes and unvisitedNodes
		Set<Node> visitedNodes = new HashSet<Node>();
		Set<Node> unVisitedNodes = new HashSet<Node>();

		// Add sourceNode to unVisitedNodes
		unVisitedNodes.add(sourceNode);

		// Iterate over unvisited nodes
		while (!unVisitedNodes.isEmpty()) {
			// get the lowest distance node for each unvisited nodes
			Node currentNode = getLowestDistanceNode(unVisitedNodes);
			// remove current Node from unvisited nodes
			unVisitedNodes.remove(currentNode);
			// get adjacency list of the currentNode
			for (Entry<Node, Integer> entry : currentNode.getAdjacencyList().entrySet()) {
				// Calculate shortest distance of adjacent/neighbor node with current
				// Node
				Node neighborNode = entry.getKey();
				int edgeWeight = entry.getValue();
				// check if neighborNode is visited or not
				// If not visited then only get the shortest distance
				if (!visitedNodes.contains(neighborNode)) {
					setShortestDistanceForNode(neighborNode, currentNode, edgeWeight);
					// add adjacent Node in Unvisited Nodes
					unVisitedNodes.add(neighborNode);
				}
			}
			// add current Node to Visited Node
			visitedNodes.add(currentNode);
		}
		// Iterate over destinationNode's shortestDistanceLink to print the path
		Node destinationNode = nodes[destinationNodeIndex];
		List<Node> shortestDistanceLink = destinationNode.getShortestDistanceLink();
		int moves = 0;
		for (Node node : shortestDistanceLink) {
			System.out.print(node.getName());
			System.out.print("-->");
			moves+=1;
		}
		System.out.print(destinationNode.getName());
		System.out.println();
		System.out.println("No of Moves via Adjacency List --> "+moves);
	}

	/**
	 * Set Shortest Distance for the neighbor node from current node
	 * 
	 * */
	private void setShortestDistanceForNode(Node neighbourNode, Node currentNode, int edgeWeight) {
		// get total distance which would be sum of edgeWeight and distance of current Node
		int totalDistance = edgeWeight + currentNode.getDistance();
		// if total distance is less than distance saved in neighbourNode 
		// that mean this is the shortest path for this neighbor node
		if (totalDistance < neighbourNode.getDistance()) {
			// set this distance as shortest distance for the neighbor
			neighbourNode.setDistance(totalDistance);
			// get the shortestDistanceLink of the current Node and add current Node to this link
			List<Node> shortestDistanceLink = new LinkedList<Node>(currentNode.getShortestDistanceLink());
			shortestDistanceLink.add(currentNode);
			// set this shortestDistanceLink
			neighbourNode.setShortestDistanceLink(shortestDistanceLink);
		}
	}
	
	/**
	 * Get Lowest Distance Node among unvisited Nodes
	 * 
	 * */
	private Node getLowestDistanceNode(Set<Node> unVisitedNodes) {
		// Check each unvisited node for lowest Distance
		Node lowestDistanceNode = null;
		int maxDistance = Integer.MAX_VALUE;
		for (Node node : unVisitedNodes) {
			if (node.getDistance() < maxDistance) {
				maxDistance = node.getDistance();
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}

}
