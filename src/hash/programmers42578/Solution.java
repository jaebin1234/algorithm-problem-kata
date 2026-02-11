package hash.programmers42578;

import java.util.*;

class Solution {

	public int solution(String[][] clothes) {
		Map<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			String name = clothes[i][0];
			String type = clothes[i][1];

			if (!map.containsKey(type)) {
				map.put(type, new ArrayList<>());
			}
			map.get(type).add(name);
		}

		//System.out.println(map);

		List<String>[] newClothes = map.values().toArray(new ArrayList[0]);

		for (List<String> list : newClothes) {
			System.out.println(list);
		}

		int answer = 1;
		for (int i = 0; i < newClothes.length; i++) {
			answer *= (newClothes[i].size() + 1);
		}

		answer -= 1;

		return answer;
	}

}
