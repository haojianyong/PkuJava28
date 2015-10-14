package debug;

public class solution237 {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }//构造方法
	}
	public static void main(String[] args) {
		

	}
	 public void deleteNode(ListNode node) {
	        if (node != null) {
				node.val = node.next.val;
				node.next = node.next.next;
			}
	        return;
	    }

}
