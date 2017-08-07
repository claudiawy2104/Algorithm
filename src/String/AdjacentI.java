package String;

public class AdjacentI {
	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = -1;
		int fast = 0;
		while (fast < array.length) {
			if (slow == -1 || array[slow] != array[fast]) {
				array[++slow] = array[fast++];
			} else {
				while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
					fast++;
				}
				slow--;
				fast++;
			}
		}
		return new String(array, 0, slow + 1);
	}
	
	public static void main(String[] args) {
		AdjacentI test = new AdjacentI();
		System.out.println(test.deDup("azzabccbbbc"));
	}
}
