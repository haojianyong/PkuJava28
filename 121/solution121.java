package debug;
//输入一个股票的股价数组，第i个元素代表第i天的股价，只允许买入卖出一次，求最大的利润
public class solution121 {
	public static int maxProfit(int[] prices) {
        int Profit=0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
			if (prices[i]<min) {
				min= prices[i];
			}
			else if(prices[i]-min>Profit){
				Profit = prices[i]-min;
			}
		}
        return Profit;
    }
	public static void main(String[] args) {
		int[] prices={9,7,4,1,3,6};
		System.out.println(maxProfit(prices));
	}
}
