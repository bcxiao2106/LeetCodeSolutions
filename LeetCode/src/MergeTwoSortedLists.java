
public class MergeTwoSortedLists {
	
	class ListNode{
		int val;
		ListNode next;
		ListNode(int i){this.val = i;}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null){
			return null;
		} else if(l1 == null && l2 != null){
			return l2;
		} else if(l1 != null && l2 == null){
			return l1;
		} else {
			ListNode root = null;
			if(l1.val <= l2.val){
				root = l1;
				l1 = l1.next;
			} else {
				root = l2;
				l2 = l2.next;
			}
			ListNode newNode = root;
			while(l1 != null || l2 != null){
				if(l1 == null){
					newNode.next = l2;
					break;
				}
				if(l2 == null){
					newNode.next = l1;
					break;
				}
				if(l1.val <= l2.val){
					newNode.next = l1;
					l1 = l1.next;
				} else {
					newNode.next = l2;
					l2 = l2.next;
				}
				newNode = newNode.next;
			}
			return root;
		}
	}

	public ListNode buildList(int[] intArr){
		ListNode root = new ListNode(intArr[0]);
		ListNode newNode = root;
		for(int i = 1; i < intArr.length; i ++){
			newNode.next = new ListNode(intArr[i]);
			newNode = newNode.next;
		}
		return root;
	}
	
	public void printList(ListNode root){
		while(root != null){
			System.out.print(root.val + ", ");
			root = root.next;
		}
	}
}
