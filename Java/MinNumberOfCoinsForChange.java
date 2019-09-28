import java.util.Arrays;

class MinNumberOfCoinsForChange {
	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		int[] coins = new int[n + 1];
		Arrays.fill(coins, Integer.MAX_VALUE);
		coins[0] = 0;
		
		for(int d : denoms)
			for(int i = d; i < n + 1; i++)
			{
				if(coins[i - d] == Integer.MAX_VALUE)
					coins[i] = Math.min(coins[i], coins[i - d]);
				
				else
					coins[i] = Math.min(coins[i], coins[i - d] + 1);
			}
		
		return coins[n] != Integer.MAX_VALUE ? coins[n] : -1;
	}
}
