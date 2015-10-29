import java.util.Vector;

/**
 * Created by ASUS on 2015/10/14.
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        boolean result=true;
        int length=Length(head);
        int [] vector=new int[length/2+1];
        int mid=length/2;
        int later=length-mid+1;
        ListNode head1=head;
        for (int i=0;i<later-1;i++){
            vector[i]=head1.val;
            head1=head1.next;
        }
        for (int i=0;i<later-1&&(mid-i-1)>=0;i++){
            if(vector[mid-i-1]==head1.val){
                head1=head1.next;
            }
            else {
                result=false;
                break;
            }
        }
        return result;
    }
    int Length(ListNode head){
        if (head==null)
            return 0;
        int count=1;
        while (head.next!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        ListNode head=new ListNode(1);
        ListNode head1=new ListNode(2);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(2);
        ListNode head4=new ListNode(1);
        //head4=s.reverse(head);
        //System.out.println(head4.val);
        /*while(head4!=null){
            System.out.println(head4.val);
            head4=head4.next;
        }*/
        head.next=head1;
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        System.out.println(s.isPalindrome(head));
    }
}
