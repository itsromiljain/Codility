/**
 * 
 */
package com.codility.example.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author romiljain
 *
 */
public class Node {
	
	private String name;
	
	private Map<Node, Integer> adjacencyList = new HashMap<Node, Integer>();
	
	public Node(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Node, Integer> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(Map<Node, Integer> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

}
