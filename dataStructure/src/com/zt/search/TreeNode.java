package com.zt.search;

public class TreeNode {

	private int value;
	
	private TreeNode parentNode;
	
	private TreeNode leftNode;
	
	private TreeNode rightNode;
	
	public int getValue() {
		return value;
	}
	
	public TreeNode(int value) {
		this.value = value;
	}

	public void setParentNode(TreeNode parentNode) {
		this.parentNode = parentNode;
	}
	
	public TreeNode getParentNode() {
		return parentNode;
	}
	
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	
	public TreeNode getLeftNode() {
		return leftNode;
	}
	
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
	public TreeNode getRightNode() {
		return rightNode;
	}

	@Override
	public String toString() {
		
		return "TreeNode[data ==" + value + "]"; 
	}
	
}
