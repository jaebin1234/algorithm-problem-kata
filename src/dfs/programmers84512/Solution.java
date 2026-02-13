package dfs.programmers84512;

import java.util.*;

class Solution {
	String[] arr = {"A", "E", "I", "O", "U"};
	List<String> dec = new ArrayList<>();

	public int solution(String word) {
		int answer = 0;

		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];
			dfs(str);
		}

		for (int i = 0; i < dec.size(); i++) {
			String find = dec.get(i);
			if (find.equals(word)) {
				answer = i + 1;
				break;
			}
		}

		return answer;
	}

	public void dfs(String str) {
		dec.add(str);

		if (str.length() == 5) return;

		for (int i = 0; i < arr.length; i++) {
			dfs(str + arr[i]);
		}

	}

}