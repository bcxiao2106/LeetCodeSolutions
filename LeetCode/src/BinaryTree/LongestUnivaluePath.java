package BinaryTree;

import util.TreeNode;

public class LongestUnivaluePath {
	
	public static int longestUnivaluePath(TreeNode root) {
        int[] result = new int[1];
        if(root != null){
        	univaluePath(root, result);
        }
		return result[0];
    }
	
	public static int univaluePath(TreeNode node, int[] result){
		int l = node.left != null ? univaluePath(node.left,result) : 0;
		int r = node.right != null ? univaluePath(node.right,result) : 0;
		int restl = (node.left != null && node.val == node.left.val) ? l + 1 : 0;
		int restr = (node.right != null && node.val == node.right.val) ? r + 1 : 0;
		result[0] = Math.max(result[0], restl + restr);
		return Math.max(restl, restr);
	}
}
