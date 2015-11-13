/**
 * Created by ASUS on 2015/11/12.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode listNode;
        listNode=head;
        while (listNode!=null){
            while (listNode.next!=null && listNode.next.val==listNode.val){
                listNode.next=listNode.next.next;
            }
            listNode=listNode.next;
        }
        return head;
    }
    public static void main(String[] args){
        ListNode listNode=new ListNode(1);
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(1);
        ListNode listNode3=new ListNode(2);
        ListNode listNode4=new ListNode(3);
        ListNode listNode5=new ListNode(3);
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        Solution solution=new Solution();
        ListNode node=solution.deleteDuplicates(listNode);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
}
