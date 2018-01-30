package BinaryTree;

import util.TreeNode;

public class ValidateBinarySearchTree {
	public static boolean isValidBST(TreeNode root) {
        return isValidSubNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	public static boolean isValidSubNode(TreeNode node, int minVal, int maxVal){
		if(node == null) return true;
		if(node.val <= minVal || node.val >= maxVal) return false;
		return isValidSubNode(node.left, minVal, node.val) && isValidSubNode(node.right, node.val, maxVal);
	}
}
