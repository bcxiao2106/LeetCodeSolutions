package BinaryTree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> resultLst = new LinkedList<List<Integer>>();
		if(root == null) return resultLst;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> levelLst = new LinkedList<Integer>();
			LinkedList<TreeNode> nextLevelQueue = new LinkedList<TreeNode>();
			for(int i = 0; i < queue.size(); i++) {
				TreeNode currNode = queue.get(i);
				levelLst.add(currNode.val);
				if(currNode.left != null) nextLevelQueue.add(currNode.left);
				if(currNode.right != null) nextLevelQueue.add(currNode.right);
			}
			resultLst.add(0,levelLst);
			queue = nextLevelQueue;
		}
		System.out.println(resultLst.size());
		return resultLst;
    }
}
