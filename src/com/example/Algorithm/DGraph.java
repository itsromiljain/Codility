/**
 * 
 */
package com.example.Algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author romiljain
 *
 */
public class DGraph {
	
	private Set<DNode> dNodes = new HashSet<DNode>();
	
	public void addNode(DNode dnode) {
		dNodes.add(dnode);
	}

	public Set<DNode> getdNodes() {
		return dNodes;
	}

	public void setdNodes(Set<DNode> dNodes) {
		this.dNodes = dNodes;
	}
	
}
