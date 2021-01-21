package com.sparkvio.codechallenges.tree;

public class TreeNode {
	
	/* Simple TreeNode. Not balanced. */
	
	private int data;
	private TreeNode parent;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	private int height;
	
	public TreeNode (int data) {
		this.data = data;
		height = 1;
	}
	
	public void insert(int newNodeData) {
		
		if (data > newNodeData) {
			if (leftChild == null) {
				leftChild = new TreeNode(newNodeData);
				leftChild.parent = this;
			}
			else {
				leftChild.insert(newNodeData);
			}
		}
		else if (data < newNodeData) {
			if (rightChild == null) {
				rightChild = new TreeNode(newNodeData);
				rightChild.parent = this;
			}
			else {
				rightChild.insert(newNodeData);
			}
		}
		height ++;
	}
	
	public TreeNode find (int dataToFind) {
		
		TreeNode foundObject = null;
		System.out.println("Encountered " + data);
		if (data == dataToFind) {
			foundObject = this;
		}
		else if (data > dataToFind) {
			System.out.println("Going left");
			foundObject = leftChild.find(dataToFind);
		}
		else {
			System.out.println("Going right");
			foundObject = rightChild.find(dataToFind);
		}
		return foundObject;
	}


	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return data + "";
	}
	
	public static void main(String[] args) {
		Integer[] inputData = {1, 6, 8, 5, 4, 3, 7, 2, 9};
		TreeNode treeNode = new TreeNode(inputData[0]);
		for (int counter = 1; counter < inputData.length; counter ++) {
			treeNode.insert(inputData[counter]);
		}
		System.out.println("Finding 7 = " + treeNode.find(7));
	}
}
