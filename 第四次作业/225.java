class MyStack {
    // Push element x onto stack.
    LinkedList<Integer> q1=new LinkedList<Integer>();
    LinkedList<Integer> q2=new LinkedList<Integer>();
    public void push(int x) {
        q1.addLast(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(q1.size()!=1){
            q2.addLast(q1.getFirst());
            q1.removeFirst();
        }
        q1.clear();
        while(!q2.isEmpty()){
            q1.addLast(q2.getFirst());
            q2.removeFirst();
        }
    }

    // Get the top element.
    public int top() {
        int val=0;
        while(!q1.isEmpty()){
            q2.addLast(q1.getFirst());
            if(q1.size()==1)val=q1.getFirst();
            q1.removeFirst();
        }
        q1.clear();
        while(!q2.isEmpty()){
            q1.addLast(q2.getFirst());
            q2.removeFirst();
        }
        return val;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
