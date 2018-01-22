package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

public class AverageofLevelsinBinaryTree {
	
	public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<Double> result = new ArrayList<Double>();
        queue.add(root);
        int levelCount = 0;
        while(!queue.isEmpty()){
        	int sum = 0;
        	levelCount = queue.size();
        	for(int i = 0; i < levelCount; i ++){
	        	TreeNode currentNode = queue.poll();
	        	sum += currentNode.val;
	        	if(currentNode.left != null){
	        		queue.add(currentNode.left);
	        	}
	        	if(currentNode.right != null){
	        		queue.add(currentNode.right);
	        	}
        	}
        	result.add(sum * 1.0 / levelCount);
        }
        return result;
    }
}
