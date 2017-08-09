package String;

public class MinInserts {
	public int insert(String input) {
		if (input == null || input.length() <= 1) {
			return 0;
		}
		char[] array = input.toCharArray();
		int[][] dp = new int[array.length][array.length];
		for (int diff = 1; diff < array.length; diff++) {
			for (int start = 0; start < array.length - diff; start++) {
				int end = start + diff;
				if (array[start] == array[end]) {
					dp[start][end] = diff == 1? 0: dp[start + 1][end - 1];
				} else {
					dp[start][end] = Math.min(dp[start + 1][end], dp[start][end - 1]) + 1;
				}
			}
		}
		return dp[0][array.length - 1];
	}
	
	public static void main(String[] args) {
		MinInserts test = new MinInserts();
		System.out.println(test.insert("abdca"));
	}
}
