package String;

public class Scramble {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] one = s1.toCharArray();
		char[] two = s2.toCharArray();
		return same(one, 0, one.length - 1, two, 0, two.length - 1);
	}

	private boolean same(char[] one, int start1, int end1, char[] two, int start2, int end2) {
		if (start1 == end1) {
			return one[start1] == two[start2];
		}
		int len1 = (end1 - start1 + 1) / 2;
		int len2 = end1 - start1 + 1 - len1;
		return (same(one, start1, start1 + len1 - 1, two, start2, start2 + len1 - 1) && same(one, end1 - len2 + 1, end1, two, end2 - len2 + 1, end2)) || //
				(same(one, start1, start1 + len1 - 1, two, end2 - len1 + 1, end2) && same(one, end1 - len2 + 1, end1, two, start2, start2 + len2 - 1));
	}
	
	public static void main(String[] args) {
		Scramble test = new Scramble();
		System.out.println(test.isScramble("great", "rgtae"));
	}
}
