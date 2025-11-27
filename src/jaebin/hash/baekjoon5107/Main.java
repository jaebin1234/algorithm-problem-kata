package jaebin.hash.baekjoon5107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder result = new StringBuilder();
		String s;
		int tk = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;

			StringBuilder sb = new StringBuilder();
			sb.append(tk).append(" ");

			Map<String, String> map = new HashMap<>();
			Set<String> visited = new HashSet<>();

			int cycleCount = 0;

			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());

				String s1 = stk.nextToken();
				String s2 = stk.nextToken();

				map.put(s1, s2);
			}

			for(String start : map.keySet()){
				if(visited.contains(start)) continue;

				String cur = start;

				while (!visited.contains(cur)){
					visited.add(cur);
					cur = map.get(cur);
				}

				cycleCount++;
			}
			sb.append(cycleCount);


			tk++;
			result.append(sb).append("\n");
		}

		System.out.println(result.toString().trim());
	}
}
