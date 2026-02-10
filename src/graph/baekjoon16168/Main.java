package graph.baekjoon16168;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(stk.nextToken());
		int e = Integer.parseInt(stk.nextToken());

		List<Integer>[] graph = new ArrayList[v + 1];

		for (int i = 0; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			stk = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		boolean[] visited = new boolean[v + 1];
		Queue<Integer> que = new LinkedList<>();

		que.add(1);
		visited[1] = true;

		while (!que.isEmpty()) {
			int cur = que.poll();

			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					que.add(next);
				}
			}
		}

		boolean connected = true;
		for (int i = 1; i <= v; i++) {
			if (!visited[i]) {
				connected = false;
				break;
			}
		}

		if (!connected) {
			System.out.println("NO");
			return;
		}

		int oddCnt = 0;
		for (int i = 1; i <= v; i++) {
			if (graph[i].size() % 2 == 1) {
				oddCnt++;
			}
		}

		if (oddCnt == 0 || oddCnt == 2) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}
}