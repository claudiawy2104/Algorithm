package Sorting;

public class QuickSort {
	public int[] quickSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		sort(array, 0, array.length - 1);
		return array;
	}
	
	private void sort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = array[end];
		int i = start;
		int j = end - 1;
		while (i <= j) {
			if (array[i] <= pivot) {
				i++;
			} else {
				swap(array, i, j);
				j--;
			}
		}
		swap(array, i, end);
		sort(array, start, i - 1);
		sort(array, i + 1, end);
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
