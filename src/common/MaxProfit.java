package common;

public class MaxProfit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] stockPrices = new int[] { 5, 2, 10, 3, 10, 5, 5, 1, 17, 4,130, 100, 140 };
		System.out.println(findMaxProfit(stockPrices));
	}

	
	public static int findMaxProfit(int[] stockPriceSamples) {
		int maxProfit = 0;
		int minTillNow = stockPriceSamples[0];
		for (int i = 0; i < stockPriceSamples.length; i++) {
			int profit = stockPriceSamples[i] - minTillNow;
			maxProfit = Math.max(profit, maxProfit);
			minTillNow = Math.min(stockPriceSamples[i], minTillNow);
		}
		return maxProfit;
	}
}
