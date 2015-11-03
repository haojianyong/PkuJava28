import java.util.Stack;

/**
 * Created by ASUS on 2015/11/2.
 */
class MyQueue{
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> temp_stack=new Stack<Integer>();
    public void push(int x){
        stack.push(x);
    }
    public void pop(){
        while (!stack.isEmpty()){
            temp_stack.push(stack.pop());
        }
        temp_stack.pop();
        while (!temp_stack.isEmpty()){
            stack.push(temp_stack.pop());
        }
    }
    public int peek(){
        while (!stack.isEmpty()){
            temp_stack.push(stack.pop());
        }
        int result=temp_stack.peek();
        while (!temp_stack.isEmpty()){
            stack.push(temp_stack.pop());
        }
        return result;
    }
    public boolean empty(){
        return stack.isEmpty();
    }
}
public class Solution {

}
