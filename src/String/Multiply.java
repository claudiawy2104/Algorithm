package String;

import java.util.Arrays;

public class Multiply {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return null;
		}
		if (num1.length() == 0 || num2.length() == 0) {
			return "";
		}
		int[] result = new int[num1.length() + num2.length()];
		for (int i = num2.length() - 1; i >= 0; i--) {
			int multi = num2.charAt(i) - '0';
			int index = result.length - num2.length() + i;
			int tens = 0;
			for (int j = num1.length() - 1; j >= 0; j--) {
				int cur = (num1.charAt(j) - '0') * multi + tens + result[index];
				tens = cur / 10;
				result[index--] = cur % 10;
			}
			if (tens > 0) {
				result[index] = tens;
			}
		}
		return toString(result);
	}

	private String toString(int[] result) {
		int start = 0;
		while (start < result.length && result[start] == 0) {
			start++;
		}
		if (start == result.length) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		while (start < result.length) {
			sb.append((char)(result[start++] + '0'));
		}
		return new String(sb);
	}
	
	public static void main(String[] args) {
		Multiply test = new Multiply();
		System.out.println(test.multiply("13", "77"));
	}
}
