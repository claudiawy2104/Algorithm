package twoDArray;

public class LargestSquareOf1s {
	public int largest(int[][] matrix) {
		int n = matrix.length;
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > 0 && j > 0 && matrix[i][j] == 1) {
					matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + 1;
				}
				result = Math.max(result, matrix[i][j]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1}};
		LargestSquareOf1s test = new LargestSquareOf1s();
		System.out.println(test.largest(matrix));
	}
}
