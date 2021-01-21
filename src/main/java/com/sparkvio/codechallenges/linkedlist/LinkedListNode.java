package com.sparkvio.codechallenges.linkedlist;

public class LinkedListNode {

	private int data;
	private LinkedListNode next;

	public LinkedListNode (int inputData, LinkedListNode nextNode) {
			this.data = inputData;
			this.next = nextNode;
	}

	public int getData() {
		return data;
	}

	public void setNext(LinkedListNode nextNode) {
		this.next = nextNode;
	}
	public LinkedListNode next() {
		return this.next;
	}
	public boolean hasNext() {
		if (this.next == null) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		LinkedListNode node4 = new LinkedListNode(50, null);
		LinkedListNode node3 = new LinkedListNode(40, node4);
		LinkedListNode node2 = new LinkedListNode(30, node3);
		LinkedListNode node1 = new LinkedListNode(20, node2);
		LinkedListNode llNode = new LinkedListNode(10, node1);
		
		System.out.println(" Value = " + llNode.getData());
		while (llNode.hasNext()) {
			
			llNode = llNode.next();
			System.out.println(" Value = " + llNode.getData());
		}
	}
}
