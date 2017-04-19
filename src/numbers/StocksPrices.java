package numbers;

public class StocksPrices {

	public static void main(String[] args) {
		int[] stocks = {1,3,0,3,5,9,2};
		int buy = 0;
		int sell = 0;
		int min = 0;
		int profit = 0;
		
		for(int i = 0; i < stocks.length; i++){
			if(stocks[i] < stocks[min]){
				min = i;
			}
				int diff = stocks[i] - stocks[min];
				if(diff > profit){
					buy = min;
					sell = i;
					profit = diff;
				}
		}
		
		System.out.println("The maximum profit is : " + profit);
		System.out.println("The stock should be bought on : " + (buy + 1));
		System.out.println("The stock should be sold on : " + (sell + 1));
	}
}
