package dfs.programmers87946;

class Solution {
	public int solution(int k, int[][] dungeons) {
		int answer = -1;
		int n = dungeons.length;

		boolean[] visited = new boolean[n];
		int clear = 0;

		int result = dfs(k, dungeons, visited, clear, n);
		answer = result;

		return answer;
	}

	public int dfs(int k, int[][] dungeons, boolean[] visited, int clear, int n) {
		int best = clear;

		for (int i = 0; i < n; i++) {
			int need = dungeons[i][0];
			int cost = dungeons[i][1];

			if (!visited[i] && k >= need && k >= cost) {
				visited[i] = true;
				best = Math.max(best, dfs(k - cost, dungeons, visited, clear + 1, n));
				visited[i] = false;
			}
		}

		return best;
	}

}