package util;

import java.util.LinkedList;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val){
		this.val = val;
	}
	
	public static TreeNode buildBinaryTree(Integer[] nodes){
		if(nodes == null || nodes.length == 0) return null;
		TreeNode root = new TreeNode(nodes[0]);
		buildBinaryTree(nodes, root, 0);
		return root;
	}
	
	public static void buildBinaryTree(Integer[] nodes, TreeNode node, int n){
		int l = 2 * n + 1;
		int r = 2 * n + 2;
		if(l < nodes.length && nodes[l] != null) {
			node.left = new TreeNode(nodes[l]);
			buildBinaryTree(nodes, node.left, l);
		}
		if(r < nodes.length && nodes[r] != null) {
			node.right = new TreeNode(nodes[r]);
			buildBinaryTree(nodes, node.right, r);
		}
	}
	
	public static void levelTraverse(TreeNode root) {
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode currNode = q.poll();
			System.out.print(currNode.val + ", ");
			if(currNode.left != null) q.add(currNode.left);
			if(currNode.right != null) q.add(currNode.right);
		}
	}
}
