package String;

public class ValidPalindrome {
	public boolean valid(String input) {
		if (input == null || input.length() <= 1) {
			return true;
		}
		char[] array = input.toCharArray();
		int start = findValid(array, 0, 1);
		int end = findValid(array, array.length - 1, -1);
		while (start < end) {
			if (array[start] != array[end]) {
				return false;
			}
			start = findValid(array, start + 1, 1);
			end = findValid(array, end - 1, -1);
		}
		return true;
	}

	private int findValid(char[] array, int index, int dir) {
		while (index >= 0 && index < array.length) {
			int value1 = array[index] - '0';
			int value2 = array[index] - 'a';
			int value3 = array[index] - 'A';
			if ((value1 >= 0 && value1 <= 9) || (value2 >= 0 && value2 < 26) //
					|| (value3 >= 0 && value3 < 26)) {
				return index;
			}
			index += dir;
		}
		return index;
	}
}
