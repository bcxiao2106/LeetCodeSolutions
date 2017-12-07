import java.util.ArrayList;
import java.util.List;

import interview.ClockAngle;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {-1,0,1,2,-1,-4};
		//ThreeSum ts = new ThreeSum(nums);
		//List<List<Integer>> resultLst = ts.findThreeSumEqualsToZero();
		//ClockAngle.findSmallerAngle(1, 5);
		//ClockAngle.findEqualTimes();
		//String s = "pwwkew";
		//System.out.println(LongestSubstring.lengthOfLongestSubstring(s));
		
		BinaryTreeNode root = new BinaryTreeNode(1,"1");
		BinaryTreeNode btn2 = new BinaryTreeNode(2,"2");
		BinaryTreeNode btn3 = new BinaryTreeNode(3,"3");
		BinaryTreeNode btn4 = new BinaryTreeNode(4,"4");
		BinaryTreeNode btn5 = new BinaryTreeNode(5,"5");
		BinaryTreeNode btn6 = new BinaryTreeNode(6,"6");
		BinaryTreeNode btn7 = new BinaryTreeNode(7,"7");
		BinaryTreeNode btn8 = new BinaryTreeNode(8,"8");
		BinaryTreeNode btn9 = new BinaryTreeNode(9,"9");
		BinaryTreeNode btn10 = new BinaryTreeNode(10,"10");
		BinaryTreeNode btn11 = new BinaryTreeNode(11,"11");
		BinaryTreeNode btn12 = new BinaryTreeNode(12,"12");
		BinaryTreeNode btn13 = new BinaryTreeNode(13,"13");
		BinaryTreeNode btn14 = new BinaryTreeNode(14,"14");
		BinaryTreeNode btn15 = new BinaryTreeNode(15,"15");
		
		root.setLeftNode(btn2);
		root.setRightNode(btn3);
		btn2.setLeftNode(btn4);
		btn2.setRightNode(btn5);
		btn3.setLeftNode(btn6);
		btn3.setRightNode(btn7);
		btn4.setLeftNode(btn8);
		btn4.setRightNode(btn9);
		btn5.setLeftNode(btn10);
		btn5.setRightNode(btn11);
		btn6.setLeftNode(btn12);
		btn6.setRightNode(btn13);
		btn7.setLeftNode(btn14);
		btn7.setRightNode(btn15);
		
		BinaryTree bt = new BinaryTree(root);
		//bt.traverse(root);
		/*
		System.out.println("\nPre order Traverse:");
		bt.preOrder(root);
		System.out.println("\nIn order Traverse:");
		bt.inOrder(root);
		System.out.println("\nPost order Traverse:");
		bt.postOrder(root);
		*/
		System.out.println("\nPre order Traverse:");
		bt.nonRecPreOrder(root);
		System.out.println("\nIn order Traverse:");
		bt.nonRecInOrder(root);
		System.out.println("\nPost order Traverse:");
		bt.nonRecPostOrder(root);
	}
	
	
}
