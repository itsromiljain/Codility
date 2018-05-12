/**
 * 
 */
package com.example.Graph;

/**
 * @author romiljain
 *
 */
public class Neighbour {
	
	private String name;

	private int index;
	
	private int edgeWeight;

	private Neighbour neighbour;
	
	public Neighbour(String name, Neighbour neighbour) {
		this.name = name;
		this.neighbour = neighbour;
	}

	public Neighbour(int index, Neighbour neighbour) {
		this.index = index;
		this.neighbour = neighbour;
	}
	
	public Neighbour(int index, int edgeWeight, Neighbour neighbour) {
		this.index = index;
		this.edgeWeight = edgeWeight;
		this.neighbour = neighbour;
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
	
	public int getEdgeWeight() {
		return edgeWeight;
	}

	public void setEdgeWeight(int edgeWeight) {
		this.edgeWeight = edgeWeight;
	}

	public Neighbour getNeighbour() {
		return neighbour;
	}

	public void setNeighbour(Neighbour neighbour) {
		this.neighbour = neighbour;
	}

}
