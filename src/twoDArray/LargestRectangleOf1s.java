package twoDArray;

public class LargestRectangleOf1s {
	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = matrix[i - 1][j] + 1;
				}
			}
		}
		int[][] left = new int[n][m];
		int[][] right = new int[n][m];
		checkLength(matrix, left, right);
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result = Math.max(result, matrix[i][j] * (left[i][j] + right[i][j] - 1));
			}
		}
		return result;
	}
	
	private void checkLength(int[][] matrix, int[][] left, int[][] right) {
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j == 0 || matrix[i][j] > matrix[i][j - 1]) {
					left[i][j] = 1;
				} else {
					left[i][j] = left[i][j - 1] + 1;
				}
				if (j == 0 || matrix[i][m - 1 - j] > matrix[i][m - j]) {
					right[i][m - 1 - j] = 1;
				} else {
					right[i][m - 1 - j] = right[i][m - j] + 1;
				}
			}
		}
	}
}
