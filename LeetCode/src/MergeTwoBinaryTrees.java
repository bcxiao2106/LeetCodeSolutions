
public class MergeTwoBinaryTrees {
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int x){
			this.val = x;
		}
	}
	
	public TreeNode createTree(Integer[] values, int n){
		if(n > values.length - 1) return null;
		TreeNode newTreeNode = null;
		if(values[n] != null){
			newTreeNode = new TreeNode(values[n]);
			if(2 * n + 1 <= values.length){
				newTreeNode.left = createTree(values, 2 * n + 1);
			} else {
				newTreeNode.left = null;
			}
			if(2 * n + 2 <= values.length){
				newTreeNode.right = createTree(values, 2 * n + 2);
			} else {
				newTreeNode.right = null;
			}
		}
		return newTreeNode;
	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        int value = 0;
        TreeNode newTreeRoot = null;
        if(t1 != null || t2 != null){
            TreeNode leftNode1 = null;
            TreeNode leftNode2 = null;
            TreeNode rightNode1 = null;
            TreeNode rightNode2 = null;
            if(t1 != null){
                value = value + t1.val;
                leftNode1 = (t1.left != null) ? t1.left : null;
                rightNode1 = (t1.right != null) ? t1.right : null;
            }
            if(t2 != null){
                value = value + t2.val;
                leftNode2 = (t2.left != null) ? t2.left : null;
                rightNode2 = (t2.right != null) ? t2.right : null;
            }
            newTreeRoot = new TreeNode(value);
            newTreeRoot.left = mergeTrees(leftNode1, leftNode2);
            newTreeRoot.right = mergeTrees(rightNode1, rightNode2);
        }
        return newTreeRoot;
    }
	
	public void traverseTree(TreeNode treeNode){
		if(treeNode != null){
			System.out.println(treeNode.val);
		}
		if(treeNode.left != null){
			traverseTree(treeNode.left);
		}
		if(treeNode.right != null){
			traverseTree(treeNode.right);
		}
	}
}
