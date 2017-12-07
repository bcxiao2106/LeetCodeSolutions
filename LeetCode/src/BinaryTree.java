import java.util.Stack;

public class BinaryTree {
	private BinaryTreeNode root;
	
	public BinaryTree(BinaryTreeNode root){
		this.root = root;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	//get height of the binary tree
	public int height(){
		return height(this.root);
	}
	
	//get height of the binary tree
	public int height(BinaryTreeNode subTree){
		if(subTree == null){
			return 0;
		}
		int l = height(subTree.getLeftNode());
		int r = height(subTree.getRightNode());
		return l > r ? (l + 1) : (r + 1);
	}
	
	//get size of the binary tree
	public int size(){
		return this.size(this.root);
	}
	
	//get size of the binary tree
	public int size(BinaryTreeNode subTree){
		if(subTree == null){
			return 0;
		}
		int l = size(subTree.getLeftNode());
		int r = size(subTree.getRightNode());
		return l + r + 1;
	}
	
	public void traverse(BinaryTreeNode subTree){
		System.out.println("KEY: " + subTree.getKey() + ", VALUE: " + subTree.getnValue());
		traverse(subTree.getLeftNode());
		traverse(subTree.getRightNode());
	}
	
	//visit a node
	public void visit(BinaryTreeNode subTree){
		System.out.println("KEY: " + subTree.getKey() + ", VALUE: " + subTree.getnValue());
		subTree.setVisited(true);
	}
	
	//pre order traverse
	public void preOrder(BinaryTreeNode subTree){
		if(subTree != null){
			this.visit(subTree);
			preOrder(subTree.getLeftNode());
			preOrder(subTree.getRightNode());
		}
	}
	
	//in order traverse
	public void inOrder(BinaryTreeNode subTree){
		if(subTree != null){
			inOrder(subTree.getLeftNode());
			this.visit(subTree);
			inOrder(subTree.getRightNode());
		}
	}
	
	//post order traverse
	public void postOrder(BinaryTreeNode subTree){
		if(subTree != null){
			postOrder(subTree.getLeftNode());
			postOrder(subTree.getRightNode());
			this.visit(subTree);
		}
	}
	
	public void nonRecPreOrder(BinaryTreeNode subTree){
		Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();
		while(subTree != null || stk.size() > 0){
			while(subTree != null){
				this.visit(subTree);
				stk.push(subTree);
				subTree = subTree.getLeftNode();
			}
			if(stk.size() > 0){
				subTree = stk.pop();
				subTree = subTree.getRightNode();
			}
		}
	}
	
	public void nonRecInOrder(BinaryTreeNode subTree){
		Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();
		while(subTree != null || stk.size() > 0){
			while(subTree != null){
				stk.push(subTree);
				subTree = subTree.getLeftNode();
			}
			if(stk.size() > 0){
				subTree = stk.pop();
				this.visit(subTree);
				subTree = subTree.getRightNode();
			}
		}
	}
	
	public void nonRecPostOrder(BinaryTreeNode subTree){
		Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();
		BinaryTreeNode tempNode = subTree;
		while(subTree != null || stk.size() > 0){
			while(subTree!= null){
				stk.push(subTree);
				System.out.println("\t Pushing : " + subTree.getKey());
				subTree = subTree.getLeftNode();
			}
			if(stk.size() > 0){
				subTree = stk.pop();
				this.visit(subTree);
				subTree = subTree.getRightNode();
			}
		}
	}
}
