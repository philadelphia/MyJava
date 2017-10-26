package com.zt.search;

public class SortedTreeSearchTest {
	private static BinarySearchTree tree = new BinarySearchTree();  
	private static BinarySearchTree tree1 = new BinarySearchTree();  
	public static void main(String[] args) {
		prepareData();
		prepareData1();
		printBinaryTree();
	}

	public static void printBinaryTree(){
		
	        System.out.println("=============================="+"采用递归的前序遍历开始"+"==============================");  
	        TreePrint.preOrderMethodOne(tree.rootNode); 
	        System.out.println();
	        TreePrint.preOrderMethodOne(tree1.rootNode); 

	        System.out.println();
	        System.out.println("=============================="+"采用递归的中序遍历开始"+"==============================");  
	        TreePrint.middleOrder(tree.rootNode);
	        System.out.println();
	        TreePrint.middleOrder(tree1.rootNode); 
	        System.out.println();  
	        System.out.println("=============================="+"采用递归的后序遍历开始"+"==============================");  
	        TreePrint.postOrder(tree.rootNode); 
	        System.out.println();
	        TreePrint.postOrder(tree1.rootNode); 
	        System.out.println();  
//	        TreeNode node =tree.findNode(20);
//	        System.out.println(node.getParentNode().getValue());
	}
	
	public static void prepareData(){
	        tree.insertData(50);  
	        tree.insertData(80);  
	        tree.insertData(20);  
	        tree.insertData(60);     
	        tree.insertData(10);  
	        tree.insertData(30);  
	        tree.insertData(70);  
	        tree.insertData(90);     
	        tree.insertData(100);  
	        tree.insertData(40);  
	}
	
	public static void prepareData1(){
        tree1.addData(50); 
        tree1.addData(50);  

        tree1.addData(80);  
        tree1.addData(20);  
        tree1.addData(60);     
        tree1.addData(10);  
        tree1.addData(30);  
        tree1.addData(70);  
        tree1.addData(90);     
        tree1.addData(100);  
        tree1.addData(40);  
}
}
