/**
 * Created by ASUS on 2015/11/1.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null)
            return false;
        ListNode quick=head;
        ListNode slow=head;
        boolean result=false;
        while (quick!=null && quick.next!=null){
            slow=slow.next;
            quick=quick.next.next;
            if(slow==quick){
                result=true;
                break;
            }
        }
        return result;
    }
}
