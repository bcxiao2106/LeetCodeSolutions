
public class BinaryTreeNode{
	private int key;
	private String nValue;
	private boolean isVisited;
	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;
	
	public BinaryTreeNode(int key, String nValue){
		this.key = key;
		this.nValue = nValue;
		this.leftNode = null;
		this.rightNode = null;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public String getnValue() {
		return nValue;
	}
	public void setnValue(String nValue) {
		this.nValue = nValue;
	}
	
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public BinaryTreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
}
