package debug;

import java.util.Stack;

//设计一个栈的方法.getmin要求时间复杂度是常量
public class solution155 {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> s = new Stack<>();//s用来存放可能的最小值
	public void push(int x) {//push的时候维护最小值
		if (s.isEmpty() || x <= s.peek()) {
			s.add(x);
		}
		stack.add(x);
    }
    public void pop() {
    	if (stack.peek().equals(s.peek())) {//写==就不过！！！ 
			s.pop();
		}
    	stack.pop();
    }

    public int top() {
			return stack.peek();
    }

    public int getMin() {//不能破坏原来的栈，笨方法:倒出来的时候确定最小，倒回去的时候把最小挑出来O(n)Time Limit Exceeded !!!!
//    	int min=0;
//    	int temp;
//    	if (!stack.isEmpty()) {
//			min = stack.peek();
//		}		
//    	while (!stack.isEmpty()) {
//    		
//    		temp= stack.peek();
//    		stack.pop();
//    		if (min > temp) {
//    			s.push(temp);
//    			min = temp;
//			}
//    		else {
//				s.push(temp);
//			}
//    		
//		}//已经挑出最小，倒回去
//    	while (!s.isEmpty()) {
//			if(s.peek()!=min ){
//	    		stack.add(s.peek());
//				s.pop();
//			}
//			else
//			s.pop();
//		}
//    	return min;
    	while (!s.isEmpty()) {
    		return s.peek();
    		}
    	return 0;
    }
}
