package com.zt.search;

import javax.xml.crypto.Data;

/**
 * 
 * @author Tao.ZT.Zhang
 *
 */

/*
 * 二叉搜索树是一种特殊的二叉树，也可以称为二叉排序树，二叉查找树。除了具有二叉树的基本性质外，它还具备：
 * 树中每个节点最多有两个子树，通常称为左子树和右子树	
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
 * 它的左右子树仍然是一棵二叉搜索树 (recursive)
 * 
 */
public class BinarySearchTree {
	public TreeNode rootNode;
	private int length;

	public boolean insertData(int value) {
		if (rootNode == null) {
			rootNode = new TreeNode(value);
			System.out.println("success to insert data");
			return true;
		}

		/*
		 * 如果根節點已經存在的話
		 */

		TreeNode treeNode = new TreeNode(value);// 即将被插入的数据
		TreeNode currentNode = rootNode;
		TreeNode parentNode;

		while (true) {
			parentNode = currentNode;

			if (value < currentNode.getValue()) {
				currentNode = currentNode.getLeftNode();
				
				if (currentNode == null) {
					parentNode.setLeftNode(treeNode);
					treeNode.setParentNode(parentNode);
					length++;
					return true;
				}
			} else if (value > currentNode.getValue()) {
				currentNode = currentNode.getRightNode();
				if (currentNode == null) {
					parentNode.setRightNode(treeNode);
					treeNode.setParentNode(parentNode);
					length++;
					return true;
				}

			} else {
				System.out.println("輸入數據與節點數據相同，插入失敗");
				return false;
			}
		}

	}

	public TreeNode findNode(int value) {
		if (rootNode == null) {
			return null;
		}
		TreeNode currentNode = rootNode;
		while (currentNode != null) {
			if (currentNode.getValue() > value) {
				currentNode = currentNode.getLeftNode();
			} else if (currentNode.getValue() < value) {
				currentNode = currentNode.getRightNode();

			} else {

				return currentNode;
			}

		}

		return null;

	}
	
	public boolean addData(int value) {
		TreeNode node = new TreeNode(value);
		if (rootNode == null) {
			rootNode = new TreeNode(value);
			System.out.println("success to insert data");
			return true;
		}
		TreeNode currentNode = rootNode;
		while(true){
			if(value <  currentNode.getValue()){
				if(null == currentNode.getLeftNode()){
					break;
				}else{
					currentNode = currentNode.getLeftNode();
				}
			}else if (value > currentNode.getValue()) {
				if(null == currentNode.getRightNode()){
					break;
				}else{
					currentNode = currentNode.getRightNode();
				}
			}else {
				System.out.println("數據重複");
				break;
			}
		}
		
		if (value < currentNode.getValue()) {
			currentNode.setLeftNode(node);
			return true;
		}else if (value > currentNode.getValue()) {
			currentNode.setRightNode(node);
			return true;
		}
		return false;
		
	
	}
}
