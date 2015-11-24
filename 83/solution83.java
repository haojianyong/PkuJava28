package debug;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class solution83 {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
	    ListNode p = head;
	    while( p!= null && p.next != null){
	        if(p.val == p.next.val){
	            p.next = p.next.next;
	        }else{
	            p = p.next; 
	        }
	    }
	    return head;
        
    }
}
