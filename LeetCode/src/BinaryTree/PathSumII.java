package BinaryTree;

import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

public class PathSumII {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> resultList = new LinkedList<List<Integer>>();
		List<Integer> currentList = new LinkedList<Integer>();
		pathValueEqualsToSum(root, sum, currentList, resultList);
		return resultList;
    }
	
	public static void pathValueEqualsToSum(TreeNode root, int sum, 
			List<Integer> currentList, List<List<Integer>> resultList) {
		if(root == null) return;
		currentList.add(new Integer(root.val));
		System.out.println(root.val);
		if(root.left == null && root.right == null && sum - root.val == 0) {
			System.out.println("Found");
			resultList.add(new LinkedList<Integer>(currentList));//find one path 
			currentList.remove(currentList.size() - 1);//remove the previous node
			return;
		} else {
			pathValueEqualsToSum(root.left, sum - root.val, currentList, resultList);
			pathValueEqualsToSum(root.right, sum - root.val, currentList, resultList);
		}
		currentList.remove(currentList.size() - 1);
	}
}
