/**
 * 
 */
package com.example.Graph;

/**
 * @author romiljain
 *
 */
public class Vertex {
	
	private String name;
	
	private Neighbour neighbour;
	
	public Vertex(String name, Neighbour neighbour){
		this.name = name;
		this.neighbour = neighbour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Neighbour getNeighbour() {
		return neighbour;
	}

	public void setNeighbour(Neighbour neighbour) {
		this.neighbour = neighbour;
	}
	
}
