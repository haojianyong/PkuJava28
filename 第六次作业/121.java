public class Solution {
    int[] lmax=new int[1000];
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int i,l,p=0,t;
        i=prices.length-1;
        l=prices[i];
        for(;i>=0;i--){
            l=prices[i]>l?prices[i]:l;
            t=l-prices[i];
            p=p<t?t:p;
        }
        return p;
    }
}
