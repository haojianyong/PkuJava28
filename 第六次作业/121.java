import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2016/1/8.
 */
//理解错意思啦，重来
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length<=1)
            return 0;
        int maxPrice=prices[prices.length-1];
        int maxprofit=0;
        for(int i=prices.length-1;i>=0;i--){
            if(prices[i]>maxPrice)
                maxPrice=prices[i];
            if(maxPrice-prices[i]>maxprofit)
                maxprofit=maxPrice-prices[i];
        }
        return maxprofit;
    }
}