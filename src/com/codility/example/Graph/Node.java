/**
 * 
 */
package com.codility.example.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author romiljain
 *
 */
public class Node {
	
	private String name;
	
	private int index;
	
	private Map<Node, Integer> adjacencyList = new HashMap<Node, Integer>();
	
	// distance and shortestDistanceLink would be used in Dijkstra Algorithm.
	private int distance = Integer.MAX_VALUE;
	
	private List<Node> shortestDistanceLink = new LinkedList<Node>();
	
	public Node(int index, String name){
		this.index = index;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Map<Node, Integer> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(Map<Node, Integer> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<Node> getShortestDistanceLink() {
		return shortestDistanceLink;
	}

	public void setShortestDistanceLink(List<Node> shortestDistanceLink) {
		this.shortestDistanceLink = shortestDistanceLink;
	}

}
