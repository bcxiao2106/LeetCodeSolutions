package BinaryTree;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class SymmetricTree {
	public static boolean isSymmetric(TreeNode root) {
		System.out.println(isMirror(root, root));
        return isMirror(root, root);
    }
    
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true; 
        if(t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
