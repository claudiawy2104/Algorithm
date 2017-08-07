package Sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortingTest {

	@Test
	public void test() {
		MergeSort sort_test = new MergeSort();
		int[] array = {0, 1};
		array = sort_test.mergeSort(array);
		int[] ans = {0, 1};
		for (int i = 0; i < ans.length; i++) {
			assertEquals(ans[i], array[i]);
		}
	}

}
