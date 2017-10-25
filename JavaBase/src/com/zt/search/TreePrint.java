package com.zt.search;

public class TreePrint {
	
	public static void preOrderMethodOne(TreeNode rootNode) {
		 if (null != rootNode) {  
	            System.out.print(rootNode.getValue() + "  ");  
	            if (null != rootNode.getLeftNode()) {  
	            	preOrderMethodOne(rootNode.getLeftNode());  
	            }  
	            if (null != rootNode.getRightNode()) {  
	            	preOrderMethodOne(rootNode.getRightNode());  
	  
	            }  
	        }  
	}

	/*
	 * 有序二叉樹的中序遍歷會產生排序的數据列表，就是遍歷出來的數據是還好序的
	 */
	public static void middleOrder(TreeNode rootNode) {
		if (rootNode != null) {
			 
		
			    if (null != rootNode.getLeftNode()) {  
			    	middleOrder(rootNode.getLeftNode());  
	            }  
	            System.out.print(rootNode.getValue() + "  ");  
	            if (null != rootNode.getRightNode()) {  
	            	middleOrder(rootNode.getRightNode());  
	            }  
			
		}

	}

	public static void postOrder(TreeNode rootNode) {
		if (rootNode != null) {
		    if (null != rootNode.getLeftNode()) {  
		    	postOrder(rootNode.getLeftNode());  
            }  
       
            if (null != rootNode.getRightNode()) {  
            	postOrder(rootNode.getRightNode());  
            } 
            
            System.out.print(rootNode.getValue() + "  ");  
		
	}
	}

}
