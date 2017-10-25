package com.zt.search;

import javax.xml.crypto.Data;

public class SearchTree {
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
}
