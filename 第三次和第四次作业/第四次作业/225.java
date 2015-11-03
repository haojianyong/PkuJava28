import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ASUS on 2015/11/2.
 */
class MyStack{
    Deque<Integer> deque=new ArrayDeque<Integer>();
    public void push(int x){
        deque.add(x);
    }
    public void pop(){
        deque.removeLast();
    }
    public int top(){
        return deque.getLast();
    }
    public boolean empty(){
        return deque.isEmpty();
    }
}
public class Solution {
    public static void main(String[] args){
        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
    }
}
