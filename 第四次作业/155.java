class MinStack {
    ArrayList<Integer> stack=new ArrayList<Integer>();
    ArrayList<Integer> minVal=new ArrayList<Integer>();
    public void push(int x) {
        stack.add(x);
        if(minVal.size()==0){
            minVal.add(x);
        }
        else{
            if(x<minVal.get(minVal.size()-1)){
                minVal.add(x);
            }
            else minVal.add(minVal.get(minVal.size()-1));
        }
    }

    public void pop() {
        stack.remove(stack.size()-1);
        minVal.remove(minVal.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minVal.get(minVal.size()-1);
    }
}
