import java.util.LinkedList;
import java.util.PriorityQueue;
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
		if(subTree == null) return;
		this.visit(subTree);
		
		traverse(subTree.getLeftNode());
		traverse(subTree.getRightNode());
	}
	//Level Traverse
	public void levelTraverse(BinaryTreeNode subTree){
		if(subTree ==  null) return;
		LinkedList<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(subTree);
		while(!q.isEmpty()){
			BinaryTreeNode currNode = q.poll();
			this.visit(currNode);
			if(currNode.getLeftNode() != null){
				q.add(currNode.getLeftNode());
			}
			if(currNode.getRightNode() != null){
				q.add(currNode.getRightNode());
			}
		}
	}
	
	//get Nodes total number of Kth level
	public int getKthLevelNodeNum(BinaryTreeNode root, int k){
		if(root == null || k < 1){
			return 0;
		}
		if(k == 1){
			return 1;
		}
		int numLeft = getKthLevelNodeNum(root.getLeftNode(), k-1);
		int numRight = getKthLevelNodeNum(root.getRightNode(), k-1);
		return numLeft + numRight;
	}
	
	//get leaf node number
	public int getLeafNodeNum(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		if(root.getLeftNode() == null && root.getRightNode() == null){
			return 1;
		}
		int numLeft = getLeafNodeNum(root.getRightNode());
		int numRight = getLeafNodeNum(root.getRightNode());
		return numLeft + numRight;
	}
	
	//Check if it is an AVL tree
	public boolean isAVL(BinaryTreeNode root, int height){
		if(root == null){
			height = 0;
			return true;
		}
		int heightLeft = 0;
		boolean leftResult = isAVL(root.getLeftNode(), heightLeft);
		int heightRight = 0;
		boolean rightResult = isAVL(root.getRightNode(), heightRight);
		if(leftResult && rightResult && Math.abs(heightLeft - heightRight) <= 1){
			height = Math.max(heightLeft, heightRight) + 1;
			return true;
		} else {
			height = Math.max(heightLeft, heightRight) + 1;
			return false;
		}
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
	
	//Non recursive pre order
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
	
	//Non recursive in order
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
	
	//Non recursive post order
	public void nonRecPostOrder(BinaryTreeNode subTree){
		Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();
		BinaryTreeNode lastVisitedNode = null;
		//push most left nodes into stack
		while(subTree!= null){
			stk.push(subTree);
			System.out.println("\t Pushing : " + subTree.getKey());
			subTree = subTree.getLeftNode();
		}
		while(stk.size() > 0){
			subTree = stk.pop();
			System.out.println("\t\t Popping : " + subTree.getKey());
			if(subTree.getRightNode() != null && subTree.getRightNode() != lastVisitedNode){
				stk.push(subTree);
				System.out.println("\t Pushing : " + subTree.getKey());
				subTree = subTree.getRightNode();
				while(subTree != null){
					stk.push(subTree);
					System.out.println("\t Pushing : " + subTree.getKey());
					subTree = subTree.getLeftNode();
				}
			} else {
				this.visit(subTree);
				lastVisitedNode = subTree;
			}
		}
	}
}
