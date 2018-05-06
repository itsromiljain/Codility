/**
 * 
 */
package com.codility.example.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author romiljain
 *
 */
public class GraphNode {
	
	Node[] nodes;
	
	/**
	 * Adjacency List Implementation
	 * 
	 * @throws FileNotFoundException
	 */
	public GraphNode(String file) throws FileNotFoundException  {
		Scanner sc = new Scanner(new File(file));
		int size = sc.nextInt();
		nodes = new Node[size];
		for(int i = 0; i < size; i++){
			Node node = new Node(i, sc.next());
			nodes[i] = node;
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
	
	/**
	 * Get Node from the name
	 * 
	 * */
	private Node getNode(String name) {
		for(int i=0; i<nodes.length; i++){
			if(name.equals(nodes[i].getName())){
				return nodes[i];
			}
		}
		return null;
	}
	
	/**
	 * Printing Graph Iterating through the nodes
	 * 
	 * */
	private void print(){
		for(int i=0; i<nodes.length; i++){
			Node vertex = nodes[i];
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
	 * Printing Graph as per BFS
	 * 
	 * */
	private void printBFS(){
		boolean[] visitedNode = new boolean[nodes.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < nodes.length; i++) {
			if (!visitedNode[i]) {
				bfs(i, visitedNode, queue);
			}
		}
	}
	
	/**
	 * BFS Implementation of a Graph
	 * Uses Queue to print each level first before proceeding to child
	 * 
	 * */
	private void bfs(int start, boolean[] visitedNode, Queue<Integer> queue) {
		// Mark this node visited
		visitedNode[start] = true;
		System.out.println(nodes[start].getName());
		// Add this node to Queue
		queue.add(start);
		while (!queue.isEmpty()) {
			int topNodeIndex = queue.poll();
			Map<Node, Integer> map = nodes[topNodeIndex].getAdjacencyList();
			for (Entry<Node, Integer> entry : map.entrySet()) {
				if (!visitedNode[entry.getKey().getIndex()]) {
					System.out.println(entry.getKey().getName());
					visitedNode[entry.getKey().getIndex()] = true;
					queue.add(entry.getKey().getIndex());
				}
			}
		}
	}
	
	/**
	 * Printing Graph as per DFS
	 * 
	 * */
	private void printDFS(){
		boolean[] visitedNode = new boolean[nodes.length];
		for (int i = 0; i < nodes.length; i++) {
			if (!visitedNode[i]) {
				dfs(i, visitedNode);
			}
		}
	}
	
	/**
	 * DFS Implementation of a Graph
	 * Uses Recursive tp print th child first
	 * 
	 */
	private void dfs(int i, boolean[] visitedNode) {
		// Mark this node visited
		visitedNode[i] = true;
		System.out.println(nodes[i].getName());
		Map<Node, Integer> map = nodes[i].getAdjacencyList();
		for (Entry<Node, Integer> entry : map.entrySet()) {
			if (!visitedNode[entry.getKey().getIndex()]) {
				System.out.println(nodes[i].getName()+"--"+entry.getKey().getName());
				dfs(entry.getKey().getIndex(), visitedNode);
			}
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
		sc.close();
		GraphNode graph = new GraphNode(file);
		System.out.println("-----Print Graph------");
		graph.print();
		// BFS Printing of Graph
		System.out.println("-----BFS------");
		graph.printBFS();
		// DFS Printing of Graph
		System.out.println("-----DFS------");
		graph.printDFS();
	}

}
