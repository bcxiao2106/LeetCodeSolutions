package BinaryTree;

import util.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {

	public static TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root = buildBST(nums, 0, nums.length - 1);
		System.out.println(root.val);
		return root;
    }
	
	public static TreeNode buildBST(int[] nums, int start, int end) {
		if(start > end) return null;
		int rootIdx = start + (end - start + 1) / 2;
		System.out.println("current rootIdx: " + rootIdx + ", value nums:" + nums[rootIdx]);
		TreeNode root = new TreeNode(nums[rootIdx]);
		
		root.left = buildBST(nums, start, rootIdx - 1);
		root.right = buildBST(nums, rootIdx + 1, end);

		return root;
	}
}
