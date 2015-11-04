public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p1,p2;
        p1=p2=head;
        while(p2!=null){
            p1=p1.next;
            p2=p2.next;
            if(p2!=null)p2=p2.next;
            else break;
            if(p1==p2)return true;
        }
        return false;
    }
}
