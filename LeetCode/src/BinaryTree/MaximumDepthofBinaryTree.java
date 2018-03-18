package BinaryTree;

import util.TreeNode;

public class MaximumDepthofBinaryTree {
	
	public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int l = 1 + maxDepth(root.left);
        int r = 1 + maxDepth(root.right);
        return (l > r) ? l : r;
    }
}
