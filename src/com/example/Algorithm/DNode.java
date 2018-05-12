/**
 * 
 */
package com.example.Algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author romiljain
 *
 */
public class DNode {
	
	private String name;
	
	private Map<DNode, Integer> adjacencyList = new HashMap<DNode, Integer>();
	
	private Integer distance = Integer.MAX_VALUE;
	
	private List<DNode> shortestPath = new LinkedList<DNode>();
	
	public DNode(String name){
		this.name = name;
	}
	
	public void addDestination(DNode destinationNode, int distance) {
		adjacencyList.put(destinationNode, distance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<DNode, Integer> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(Map<DNode, Integer> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public List<DNode> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<DNode> shortestPath) {
		this.shortestPath = shortestPath;
	}

}
