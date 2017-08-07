package Sorting;

public class MergeSort {
	public int[] mergeSort(int[] input) {
		if (input == null || input.length <= 1) {
			return input;
		}
		int[] helper = new int[input.length];
		sort(input, 0, input.length - 1, helper);
		return input;
	}
	
	private void sort(int[] array, int start, int end, int[] helper) {
		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;
		sort(array, start, mid, helper);
		sort(array, mid + 1, end, helper);
		merge(array, start, mid, end, helper);
	}
	
	private void merge(int[] array, int start, int mid, int end, int[] helper) {
		for (int i = start; i <= end; i++) {
			helper[i] = array[i];
		}
		int i = start;
		int j = mid + 1;
		while (i <= mid && j <= end) {
			if (helper[i] < helper[j]) {
				array[start++] = helper[i++];
			} else {
				array[start++] = helper[j++];
			}
		}
		while (i <= mid) {
			array[start++] = helper[i++];
		}
	}
}
