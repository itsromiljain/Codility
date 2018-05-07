/**
 * 
 */
package com.codility.example.Graph;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * @author romiljain
 * 
 * This class implements Dijkstra Algorithm to find the shortest path between to nodes in a graph.
 *
 */
public class DijkstraAlgorithm {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Graph File Name: ");
		String file = sc.nextLine();
		System.out.print("Enter Source Node: ");
		String sourceNode = sc.nextLine();
		System.out.print("Enter Destination Node: ");
		String destinationNode = sc.nextLine();
		sc.close();
		GraphNode graph = new GraphNode(file);
		calculateShortestDistance(graph, sourceNode, destinationNode);
	}

	private static void calculateShortestDistance(GraphNode graph, String sourceNodeName, String destinationNodeName) {
		Node sourceNode = getNode(graph.nodes, sourceNodeName);
		
		Set<Node> visitedNodes = new HashSet<Node>();
		Set<Node> unvisitedNodes = new HashSet<Node>();
		
		sourceNode.setDistance(0);
		// First Add Source Node to unvisitedNodes
		unvisitedNodes.add(sourceNode);
		
		// Run While loop till all nodes are visited or unvisitedNodes Set is Empty
		while(!unvisitedNodes.isEmpty()) {
			// Get the node with lowest distance
			Node currentNode = getLowestDistanceNode(unvisitedNodes);
			
			unvisitedNodes.remove(currentNode);
			for(Entry<Node, Integer> entry : currentNode.getAdjacencyList().entrySet()){
				Node adjacentNode = entry.getKey();
				int edgeWeight = entry.getValue();
				if(!visitedNodes.contains(adjacentNode)){
					// Calculate shortest distance of adjacent node with current Node
					calculateMinimumDistance(currentNode, adjacentNode, edgeWeight);
					// Add adjacent node to unvisited
					unvisitedNodes.add(adjacentNode);
				}
			}
			visitedNodes.add(currentNode);
		}
		Node destinationNode = getNode(graph.nodes, destinationNodeName);
		List<Node> shortestDistanceLink = destinationNode.getShortestDistanceLink();
		for(Node node : shortestDistanceLink){
			System.out.print(node.getName());
			System.out.print("-->");
		}
		System.out.print(destinationNodeName);
	}
	
	private static void calculateMinimumDistance(Node currentNode, Node adjacentNode, int edgeWeight) {
		int currentNodeDistance = currentNode.getDistance();
		if(adjacentNode.getDistance() > (currentNodeDistance + edgeWeight)){
			adjacentNode.setDistance(currentNodeDistance + edgeWeight);
			List<Node> shortestDistanceLink = new LinkedList<Node>(currentNode.getShortestDistanceLink());
			shortestDistanceLink.add(currentNode);
			adjacentNode.setShortestDistanceLink(shortestDistanceLink);
		}
	}

	private static Node getLowestDistanceNode(Set<Node> unvisitedNodes) {
		Node lowestDistanceNode = null;
		int maxDistance = Integer.MAX_VALUE;
		for(Node node : unvisitedNodes){
			int distance = node.getDistance();
			if(maxDistance > distance) {
				lowestDistanceNode = node;
				maxDistance = distance;
			}
		}
		return lowestDistanceNode;
	}

	private static Node getNode(Node[] nodes, String nodeName){
		for(Node node : nodes){
			if(node.getName().equals(nodeName))
				return node;
		}
		return null;
	}

}
