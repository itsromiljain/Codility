/**
 * 
 */
package com.codility.example.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * @author romiljain
 *
 */
public class GraphNode {
	
	Set<Node> nodes;
	
	/**
	 * Adjacency List Implementation
	 * 
	 * @throws FileNotFoundException
	 */
	public GraphNode(String file) throws FileNotFoundException  {
		Scanner sc = new Scanner(new File(file));
		int size = sc.nextInt();
		nodes = new HashSet<Node>();
		for(int i = 0; i < size; i++){
			Node node = new Node(sc.next());
			nodes.add(node);
		}
		while(sc.hasNext()){
			Node vertex = getNode(sc.next());
			Node neighbor = getNode(sc.next());
			int distance = sc.nextInt();
			Map<Node, Integer> map = vertex.getAdjacencyList();
			map.put(neighbor, distance);
			vertex.setAdjacencyList(map);
		}
		sc.close();
	}
	
	private Node getNode(String name) {
		Iterator<Node> itr = nodes.iterator();
		while(itr.hasNext()){
			Node node = itr.next();
			if(name.equals(node.getName())){
				return node;
			}
		}
		return null;
	}
	
	private void print(){
		Iterator<Node> itr = nodes.iterator();
		while(itr.hasNext()){
			Node vertex = itr.next();
			Map<Node, Integer> map = vertex.getAdjacencyList();
			System.out.print(vertex.getName());
			for(Entry<Node, Integer> entry: map.entrySet()){
				System.out.print(" ------");
				System.out.print(" ("+entry.getValue()+") ");
				System.out.print(entry.getKey().getName());
			}
			System.out.println();
			
		}
	}
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Graph File Name: ");
		String file = sc.nextLine();
		GraphNode graph = new GraphNode(file);
		graph.print();
		sc.close();

	}

}
