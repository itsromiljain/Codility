/**
 * 
 */
package com.codility.example;

/**
 * @author romiljain
 * Writing programming interview questions hasn't made me rich yet ... so I might give up and start trading Apple stocks all day instead.
 * First, I want to know how much money I could have made yesterday if I'd been trading Apple stocks all day.
 * So I grabbed Apple's stock prices from yesterday and put them in a list called stock_prices_yesterday, where:
 * The indices are the time (in minutes) past trade opening time, which was 9:30am local time.
 * The values are the price (in US dollars) of one share of Apple stock at that time.
 * So if the stock cost $500 at 10:30am, that means stock_prices_yesterday[60] = 500.
 * Write an efficient function that takes stock_prices_yesterday and returns the best profit I could have made from one purchase and one sale of one share of Apple stock yesterday.
    For example:
    stock_prices_yesterday = [10, 7, 5, 8, 11, 9]
	int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
 * No "shorting"—you need to buy before you can sell. Also, you can't buy and sell in the same time step—at least 1 minute has to pass.
 */
public class StockPriceTrade {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] stockPricesYesterday = new int[] { 11, 10, 12, 9, 7, 5, 8 };
		StockPriceTrade spt = new StockPriceTrade();
		spt.getMaxProfit(stockPricesYesterday);
	}

	public void getMaxProfit(int[] stockPricesYesterday) {
		// returns 6 (buying for $5 and selling for $11)
		// Find the max value in Array and min value in Array with index.
		// Max value index needs to be greater than Min Value Index
		int maxValueIndex = 0;
		int maxValue = stockPricesYesterday[0];
		for (int i = 1; i < stockPricesYesterday.length; i++) {
			if (stockPricesYesterday[i] > maxValue) {
				maxValue = stockPricesYesterday[i];
				maxValueIndex = i;
			}
		}
		int minValueIndex = 0;
		int minValue = stockPricesYesterday[0];
		// Stock price may fall after reaching to peak that day
		// So we have to find Min Value of the stock before Max Value of the
		// Stock So that we can maximize the returns.
		minValue = stockPricesYesterday[0];
		for (int i = 1; i < maxValueIndex; i++) {
			if (stockPricesYesterday[i] < minValue) {
				minValue = stockPricesYesterday[i];
				minValueIndex = i;
			}
		}
		
		System.out.println("Max Value:->" +maxValue + " Min Value:->"+minValue);
		System.out.println("Max Value Index:->" +maxValueIndex + " Min Value Index:->"+minValueIndex);
		
	}

}
