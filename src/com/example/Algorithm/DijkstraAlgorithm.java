/**
 * 
 */
package com.example.Algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author romiljain
 *
 */
public class DijkstraAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DNode DNodeA = new DNode("A");
		DNode DNodeB = new DNode("B");
		DNode DNodeC = new DNode("C");
		DNode DNodeD = new DNode("D"); 
		DNode DNodeE = new DNode("E");
		DNode DNodeF = new DNode("F");
		 
		DNodeA.addDestination(DNodeB, 10);
		DNodeA.addDestination(DNodeC, 15);
		 
		DNodeB.addDestination(DNodeD, 12);
		DNodeB.addDestination(DNodeF, 15);
		 
		DNodeC.addDestination(DNodeE, 10);
		 
		DNodeD.addDestination(DNodeE, 2);
		DNodeD.addDestination(DNodeF, 1);
		 
		DNodeF.addDestination(DNodeE, 5);
		 
		DGraph graph = new DGraph();
		 
		graph.addNode(DNodeA);
		graph.addNode(DNodeB);
		graph.addNode(DNodeC);
		graph.addNode(DNodeD);
		graph.addNode(DNodeE);
		graph.addNode(DNodeF);
		 
		graph = DijkstraAlgorithm.calculateShortestPathFromSource(graph, DNodeA);
		System.out.println(graph);
	}

	private static DGraph calculateShortestPathFromSource(DGraph graph, DNode sourceNode) {
		// sourceNode is nothing but NodeA
		Set<DNode> visitedNodes = new HashSet<DNode>();
		Set<DNode> unvisitedNodes = new HashSet<DNode>();
		
		sourceNode.setDistance(0);
		unvisitedNodes.add(sourceNode);
		
		while (!unvisitedNodes.isEmpty()) {
	        DNode currentNode = getLowestDistanceNode(unvisitedNodes);
	        unvisitedNodes.remove(currentNode);
	        for (Entry < DNode, Integer> adjacencyPair: 
	          currentNode.getAdjacencyList().entrySet()) {
	            DNode adjacentNode = adjacencyPair.getKey();
	            System.out.println("Node--->"+adjacentNode.getName());
	            Integer edgeWeight = adjacencyPair.getValue();
	            if (!visitedNodes.contains(adjacentNode)) {
	                calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
	                unvisitedNodes.add(adjacentNode);
	            }
	        }
	        visitedNodes.add(currentNode);
	    }
		return graph;
	}
	
	private static DNode getLowestDistanceNode(Set <DNode> unvisitedNodes) {
	    DNode lowestDistanceNode = null;
	    int lowestDistance = Integer.MAX_VALUE;
	    for (DNode node: unvisitedNodes) {
	        int nodeDistance = node.getDistance();
	        if (nodeDistance < lowestDistance) {
	            lowestDistance = nodeDistance;
	            lowestDistanceNode = node;
	        }
	    }
	    return lowestDistanceNode;
	}
	
	private static void calculateMinimumDistance(DNode evaluationNode,
			  Integer edgeWeigh, DNode sourceNode) {
			    Integer sourceDistance = sourceNode.getDistance();
			    if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			    	System.out.println("sourceNode-->"+sourceNode.getName()+"  evaluationNode-->"+evaluationNode.getName());
			        evaluationNode.setDistance(sourceDistance + edgeWeigh);
			        List<DNode> shortestPath = new LinkedList<DNode>(sourceNode.getShortestPath());
			        shortestPath.add(sourceNode);
			        evaluationNode.setShortestPath(shortestPath);
			    }
			}

}
