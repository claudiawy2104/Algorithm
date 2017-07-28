package Sorting;

import java.util.Deque;
import java.util.LinkedList;

public class SortBy2Stacks {
	public Deque<Integer> sort(Deque<Integer> in) {
		Deque<Integer> stack = new LinkedList<>();
		while (!in.isEmpty()) {
			int cur = in.pop();
			while (!stack.isEmpty() && stack.peek() < cur) {
				in.push(stack.pop());
			}
			stack.push(cur);
		}
		return stack;
	}
	
	public static void main(String[] args) {
		SortBy2Stacks test = new SortBy2Stacks();
		Deque<Integer> in = new LinkedList<Integer>();
		in.add(-2);
		in.add(0);
		Deque<Integer> ans = test.sort(in);
		for (int i: ans) {
			System.out.println(i);
		}
	}
}
