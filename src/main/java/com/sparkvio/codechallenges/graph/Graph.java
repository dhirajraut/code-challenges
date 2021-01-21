package com.sparkvio.codechallenges.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

	Map<Node, LinkedList<Node>> adjecentNodes;
	
	public Graph() {
		adjecentNodes = new HashMap<Graph.Node, LinkedList<Node>>();
	}
	
	public boolean hasEdge (Node source, Node target) {
		
		if (adjecentNodes.get(source) != null && adjecentNodes.get(source).contains(target)) {
			return true;
		}
		return false;
	}
	
	public void insertNode(Node source, Node target) {
		
		LinkedList<Node> nodeLL;
		
		/* Add source to target edge. */
		if (!adjecentNodes.containsKey(source)) {
			nodeLL = new LinkedList<Node>();
		}
		else {
			nodeLL = adjecentNodes.get(source);
		}
		nodeLL.add(target);
		adjecentNodes.put(source, nodeLL);

		/* Add target to source edge. */
		if (!adjecentNodes.containsKey(target)) {
			nodeLL = new LinkedList<Node>();
		}
		else {
			nodeLL = adjecentNodes.get(target);
		}
		nodeLL.add(source);
		adjecentNodes.put(target, nodeLL);
	}
	
	private class Node {
		String label;

		Node(String label) {
			this.label = label;
		}
		
	}
}
