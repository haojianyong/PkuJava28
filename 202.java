public class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        if(n==1)return true;
        int res=n,s;
        while(res!=1){
            s=0;
            while(res!=0){
                s+=(res%10)*(res%10);
                res/=10;
            }
            res=s;
            if(res==1)return true;
            if(hm.containsKey(res))return false;
            else{
                hm.put(res,1);
            }
        }
        return false;
    }
}
