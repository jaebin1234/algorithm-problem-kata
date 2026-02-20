package string.programmers155652;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public String solution(String s, String skip, int index) {
		String answer = "";

		Set<Character> set = new HashSet<>();

		for (int i = 0; i < skip.length(); i++) {
			set.add(skip.charAt(i));
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);

			int moved = 0;

			while (moved < index) {
				cur++;
				if (cur > 'z') cur = 'a';

				if (set.contains(cur)) {
					continue;
				}

				moved++;
			}

			sb.append(cur);
		}

		answer = sb.toString();
		return answer;
	}
}