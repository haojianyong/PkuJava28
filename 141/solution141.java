package debug;
//判断链表中是否有环，需要考虑没有环的时候
class ListNode {//定义链表节点
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
}
public class solution141 {
	public boolean hasCycle(ListNode head) {
        boolean result=false;
        ListNode p = head;
        ListNode q = head;
        while (p != null && q != null && q.next != null) {
			p = p.next;//快慢指针
			q = q.next.next;
			if (p==q) {
				return true;
			}
		}
        return result;
    }
}
