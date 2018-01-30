package BinaryTree;

import java.util.List;

import util.TreeNode;

public class DiameterofBinaryTree {
	public static int diameterOfBinaryTree(TreeNode root) {
		System.out.println(height(root.left));
		System.out.println(height(root.right));
        return 1;
    }
	public static int height(TreeNode node) {
		if(node == null) return 0;
		int l = height(node.left);
		int r = height(node.right);
		return l > r ? l + 1 : r + 1;
	}
}
