package util;

//public class ListNode implements Comparable<ListNode> {
public class ListNode{
	public int val;
	public ListNode next;
	
	public ListNode(int val){
		this.val = val;
	}
	
	public static ListNode buildList(int[] intArr){
		ListNode root = new ListNode(intArr[0]);
		ListNode newNode = root;
		for(int i = 1; i < intArr.length; i ++){
			newNode.next = new ListNode(intArr[i]);
			newNode = newNode.next;
		}
		return root;
	}
	
	public static void printList(ListNode root){
		while(root != null){
			System.out.print(root.val + ", ");
			root = root.next;
		}
		System.out.println();
	}

	/*
	@Override
	public int compareTo(ListNode o) {
		// TODO Auto-generated method stub
		if(o == null){
			return this.val;
		}
		if(this != o){
			return this.val - o.val;
		}
		return 0;
	}
	*/
}
