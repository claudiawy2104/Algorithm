package DP;

public class LargestProductRectangle {
	class Element {
		double product;
		int zeros;
		
		Element(double product, int zeros) {
			this.product = product;
			this.zeros = zeros;
		}
	}
	
	public double largest(double[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int n = matrix.length;
		int m = matrix[0].length;
		Element[][] updown = new Element[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0) {
					int count = matrix[i][j] == 0 ? 1: 0;
					updown[i][j] = new Element(matrix[i][j], count);
				} else if (matrix[i][j] == 0){
					updown[i][j] = new Element(updown[i - 1][j].product, updown[i - 1][j].zeros + 1);
				} else {
					double cur_prod = updown[i - 1][j].product == 0 ? matrix[i][j]: updown[i - 1][j].product * matrix[i][j];
					updown[i][j] = new Element(cur_prod, updown[i - 1][j].zeros);
				}
			}
		}
		double[] cur = new double[m];
		double result = Double.MIN_VALUE;
		for (int lower = 0; lower < n; lower++) {
			for (int upper = 0; upper <= lower; upper++) {
				for (int i = 0; i < m; i++) {
					if (upper == 0) {
						cur[i] = updown[lower][i].zeros > 0? 0: updown[lower][i].product;
					} else if (updown[lower][i].zeros > updown[upper - 1][i].zeros) {
						cur[i] = 0; 
					} else {
						cur[i] = updown[upper - 1][i].product == 0? updown[lower][i].product: updown[lower][i].product / updown[upper - 1][i].product;
					}
				}
				result = Math.max(result, findLargest(cur));
			}
		}
		return result;
	}
	
	private double findLargest(double[] array) {
		double result = array[0];
		double min = array[0];
		double max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < 0) {
				double temp = min;
				min = max;
				max = temp;
			}
			min = Math.min(array[i], array[i] * min);
			max = Math.max(array[i], array[i] * max);
			result = Math.max(result, max);
		}
		return result;
	}
	
	public static void main (String[] args) {
		double[][] input = {{0, -0.2, 0, -1.0}, {-4.0, 0, -1.0, 0}};
		LargestProductRectangle test = new LargestProductRectangle();
		System.out.println(test.largest(input));
	}
}
