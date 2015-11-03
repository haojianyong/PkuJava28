import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2015/11/2.
 */
class MinStack{
    List<Integer> list=new ArrayList<Integer>();
    public void push(int x){
        list.add(x);
    }
    public void pop(){
        list.remove(list.size()-1);
    }
    public int top(){
        return list.get(list.size()-1);
    }
    public int getMin(){
        int min=list.get(0);
        for (int i=1;i<list.size();i++){
            if(list.get(i)<min){
                min=list.get(i);
            }
        }
        return min;
    }
}
public class Solution {
    public static void main(String[] args){
        MinStack minStack=new MinStack();
        for(int i=5;i>3;i--)
            minStack.push(i);
        System.out.println(minStack.getMin());
        for (int i=0;i<2;i++){
            System.out.println(minStack.top());
            minStack.pop();
        }
    }
}
