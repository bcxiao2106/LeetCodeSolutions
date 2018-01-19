import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import util.ListNode;

public class MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		ListNodeComparator comparator = new ListNodeComparator();
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(comparator);
		ListNode head = null;
		ListNode currentNode = null;
		for(int i = 0; i < lists.length; i ++){
			if(lists[i] == null) continue;
			currentNode = lists[i];
			while(currentNode != null){
				pq.offer(currentNode);
				currentNode = currentNode.next;
			}
		}
		System.out.println("Save finished" + pq.size());
		System.out.println(pq.peek().val);
		head = pq.poll();
		System.out.println("Head value: " + head.val);
		currentNode = head;
		while(!pq.isEmpty()){
			System.out.println(pq.peek().val);
			currentNode.next = pq.poll();
			System.out.println("currentNode value: " + currentNode.val);
			currentNode = currentNode.next;
		}
		System.out.println("currentNode value: " + currentNode.val);
		currentNode.next = null;
		
		return head;
	}
}

class ListNodeComparator implements Comparator<ListNode>{

	@Override
	public int compare(ListNode o1, ListNode o2) {
		return o1.val - o2.val;
	}
	
}