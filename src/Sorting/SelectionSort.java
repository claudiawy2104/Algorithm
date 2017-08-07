package Sorting;

public class SelectionSort {
	public int[] solve(int[] array) { // -3 -1 4 7
		int n = array.length;
		for (int i = 0; i < n; i++) { // in total n loops; i = 4
			int global_min_index = i; // 3
			for (int j = i; j < n; j++) { //j = 
				if (array[j] < array[global_min_index]) {
					global_min_index = j;
				}
			}
			swap(array, i, global_min_index);
		}
		return array;
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		SelectionSort juelin = new SelectionSort();
		int[] input = {-3, 1, -4, 7};
		input = juelin.solve(input);
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}
}
