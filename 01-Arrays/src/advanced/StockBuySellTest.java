package advanced;

public class StockBuySellTest {

	public static void main(String[] args) {
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		stockBuySell(price, price.length);
	}

	// This function finds the buy sell schedule for maximum profit
	public static void stockBuySell(int price[], int n) {
		if (n == 1)
			return;

		int count = 0; // count of solution pairs

		int len = (n / 2) + 1;
		Range[] sol = new Range[len];

		int i = 0;
		while (i < n - 1) {
			Range one = new Range();

			// Find Local Minima.
			while ((i < n - 1) && (price[i + 1] <= price[i]))
				i++;
			if (i == n - 1)
				break;
			// Store the index of minima
			one.buy = i++;
			// Find Local Maxima.
			while ((i < n) && (price[i] >= price[i - 1]))
				i++;
			// Store the index of maxima
			one.sell = i - 1;

			sol[count] = one;

			// Increment count of buy/sell pairs
			count++;
		}

		// print solution
		if (count == 0)
			System.out.printf("There is no day to make profit\n");
		else {
			for (i = 0; i < count; i++)
				System.out.printf("Buy day: %d\t Sell day: %d\n", sol[i].buy,
						sol[i].sell);
		}
		return;
	}

	static class Range {
		int buy;
		int sell;

		public Range() {
		}
	}

}
