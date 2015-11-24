package debug;
import java.util.LinkedList;
import java.util.Queue;

//两个队列模拟栈
public class solution225 {
	private Queue<Integer> p = new LinkedList<>(); 
	private Queue<Integer> q = new LinkedList<>(); 
	// Push element x onto stack.
    public void push(int x) {//入栈操作直接在队尾加入元素
        p.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {//出栈操作，把p除最后一个元素都poll出到q
        while (p.size() > 1) {
			q.offer(p.poll());
		}
        p.poll();
        Queue temp = p;
        p = q;
        q = temp;
    }

    // Get the top element.
    public int top() {
    	while (p.size() > 1) {
			q.offer(p.poll());
		}
        int top = p.peek();
        q.offer(p.poll());
        Queue temp = p;
        p = q;
        q = temp;
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {//两队列皆为空
    	return p.isEmpty();  
    }

}
