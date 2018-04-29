/**
 * 
 */
package com.codility.example.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author romiljain
 *
 */
public class Graph {

	Vertex[] adjacencyList;

	/**
	 * Adjacency List Implementation
	 * 
	 * @throws FileNotFoundException
	 */
	public Graph(String file) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));
		String graphType = sc.next();
		boolean isUnDirected = false;
		if(graphType.equals("undirected")){
			isUnDirected = true;
		}
		
		adjacencyList = new Vertex[sc.nextInt()];

		for (int i = 0; i < adjacencyList.length; i++) {
			Vertex vertex = new Vertex(sc.next(), null);
			adjacencyList[i] = vertex;
		}
		
		while(sc.hasNext()){
			int v1 = getIndexForName(sc.next());
			int v2 = getIndexForName(sc.next());
			adjacencyList[v1].setNeighbour(new Neighbour(v2, adjacencyList[v1].getNeighbour()));
			if(isUnDirected)
				adjacencyList[v2].setNeighbour(new Neighbour(v1, adjacencyList[v2].getNeighbour()));
		}
		sc.close();
	}
	
	private void print(){
		for(int i=0; i < adjacencyList.length; i++){
			Vertex vertex = adjacencyList[i];
			Neighbour neigbour = vertex.getNeighbour();
			System.out.print(vertex.getName());
			while(neigbour != null){
				System.out.print("--->"+adjacencyList[neigbour.getIndex()].getName());
				neigbour = neigbour.getNeighbour();
			}
			System.out.println();
		}
	}

	private int getIndexForName(String name) {
		for(int i=0; i<adjacencyList.length; i++){
			if(name.equals(adjacencyList[i].getName())){
				return i;
			}
		}
		return -1;
	}

	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Graph File Name: ");
		String file = sc.nextLine();
		Graph graph = new Graph(file);
		graph.print();
		sc.close();
	}
}
