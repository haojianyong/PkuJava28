/**
 * Created by ASUS on 2015/9/26.
 */
public class Solution {
    public int hammingWeight(int n) {
        int count=0;
        //while(n>0){
        while(n!=0){
            //if(n%2==1)
            //    count++;
           // n=n/2;
            count=count+(n & 1);
            n >>>= 1;
        }
        return count;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        System.out.println("sbasj");
        int x=s.hammingWeight(11);
        System.out.println();

    }
}
