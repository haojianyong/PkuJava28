class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> s1=new Stack<Integer>();
    Stack<Integer> s2=new Stack<Integer>();
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!s1.isEmpty()){
            if(s1.size()==1)break;
            s2.push(s1.pop());
        }
        s1.clear();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        int val=0;
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        val=s2.peek();
        s1.clear();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return val;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }
}
