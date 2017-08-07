package String;

public class Reverse {
	public String reverseWords(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int index = 0;
		int start = findChar(array, 0);
		int end = start;
		while (end < array.length) {
			while (end < array.length && array[end] != ' ') {
				end++;
			}
			reverse(array, start, end - 1);
			index = copy(array, index, start, end - 1);
			if (index < array.length) {
				array[index++] = ' ';
			}
		}
		if (array[index - 1] == ' ') {
			index--;
		}
		reverse(array, 0, index - 1);
		return new String(array, 0, index);
	}
	
	private int copy(char[] array, int index, int start, int end) {
		for (int i = start; i <= end; i++) {
			array[index++] = array[i];
		}
		return index;
	}
	
	private void reverse(char[] array, int start, int end) {
		while (start < end) {
			char temp = array[start];
			array[start++] = array[end];
			array[end--] = temp;
		}
	}
	
	private int findChar(char[] array, int start) {
		while (start < array.length && array[start] == ' ') {
			start++;
		}
		return start;
	}
	
	public static void main(String[] args) {
		String input = "an apple";
		AdjacentI test = new AdjacentI();
		System.out.println(test.reverseWords(input));
	}
}
