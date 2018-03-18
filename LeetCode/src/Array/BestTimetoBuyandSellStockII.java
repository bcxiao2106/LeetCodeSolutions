package Array;

public class BestTimetoBuyandSellStockII {
	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2 ) return 0;
        int profits = 0, buyPoint = prices[0], sellPoint = 0; 
        boolean isUpTrend = prices[0] <= prices[1] ? true : false;
        for(int i = 0; i < prices.length; i ++) {
            if(isUpTrend) {
            	System.out.println((i + 1) < prices.length - 1);
                if(i < prices.length - 1 && prices[i] <= prices[i + 1]) continue;
                isUpTrend = false;
                sellPoint = prices[i];
                profits += sellPoint - buyPoint;
                System.out.println("is up trend? " + isUpTrend);
                System.out.println("buypoint: " + buyPoint + ", sellpoint: " + sellPoint);
            } else {
                if(i < prices.length - 1 && prices[i] >= prices[i + 1]) continue;
                isUpTrend = true;
                buyPoint = prices[i];
                System.out.println("is up trend? " + isUpTrend);
                System.out.println("current buypoint: " + buyPoint);
            }
        }
        System.out.println(profits);
        return profits;
    }
}
