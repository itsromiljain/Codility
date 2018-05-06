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
	
	private int index;
	
	private Map<Node, Integer> adjacencyList = new HashMap<Node, Integer>();
	
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
	
}
