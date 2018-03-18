package BinaryTree;

import util.TreeNode;

public class PathSum {
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
        boolean isLeft = hasPathSum(root.left, sum - root.val);
        boolean isRight = hasPathSum(root.right, sum - root.val);
        return isLeft || isRight;
    }
}
