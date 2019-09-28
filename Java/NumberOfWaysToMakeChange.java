class NumberOfWaysToMakeChange {
	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		int[] ways = new int[n + 1];
		
		ways[0] = 1;
		
		for(int d : denoms)
			for(int i = d; i < n + 1; i++)
					ways[i] += ways[i - d];
		
		return ways[n];
	}
}
