import util.ListNode;

public class IntersectionofTwoLinkedLists {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
        ListNode currNode = headA;
        int countA = 0, countB = 0, offset = 0;
        while(currNode.next != null) {
        	System.out.println("Current A: " + currNode.val);
            currNode = currNode.next;
            ++countA;
        }
        currNode = headB;
        while(currNode.next != null) {
        	System.out.println("Current B: " + currNode.val);
            currNode = currNode.next;
            ++countB;
        }
        System.out.println("headA: " + headA.val + ", headB: " + headB.val);
        if(countA > countB) currNode = findIntersectionNode(headA, headB, countA - countB);
        if(countA == countB) currNode = findIntersectionNode(headA, headB, 0);
        if(countA < countB) currNode = findIntersectionNode(headB, headA, countB - countA);
        System.out.println("countA: " + countA + ", countB: " + countB + ", IntersectionNodeValue: " + currNode.val + ", offset: " + (countA - countB));
        return currNode;
    }
    public static ListNode findIntersectionNode(ListNode longerList, ListNode shorterList, int offset) {
        ListNode lNode = longerList, sNode = shorterList;
        while(offset > 0) {
        	System.out.println("offset: " + offset);
            lNode = lNode.next;
            --offset;
        }
        while(lNode != sNode) {
            lNode = lNode.next;
            sNode = sNode.next;
        }
        System.out.println(lNode.val + ", " + sNode.val);
        if(lNode == null) return null;
        return lNode;
    }
}
