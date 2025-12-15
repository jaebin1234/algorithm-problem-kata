package jaebin.implementation.baekjoon16509;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(stk.nextToken());
		int c1 = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());

		int r2 = Integer.parseInt(stk.nextToken());
		int c2 = Integer.parseInt(stk.nextToken());


		boolean[][] visited = new boolean[10][9];

		visited[r1][c1] = true;
		Queue<int[]> que = new LinkedList<>();

		que.add(new int[]{r1, c1, 0});

		int[] dy1 = {-1, -1, 0, 0, 1, 1, 0, 0};
		int[] dx1 = {0, 0, -1, -1, 0, 0, 1, 1};

		int[] dy2 = {-1, -1, -1, 1, 1, 1, -1, 1};
		int[] dx2 = {-1, 1, -1, -1, -1, 1, 1, 1};

		int[] dy3 = {-1, -1, -1, 1, 1, 1, -1, 1};
		int[] dx3 = {-1, 1, -1, -1, -1, 1, 1, 1};

		while (!que.isEmpty()) {
			int[] poll = que.poll();

			int y = poll[0];
			int x = poll[1];
			int cnt = poll[2];

			if (y == r2 && x == c2) {
				System.out.println(cnt);
				return;
			}

			for (int i = 0; i < 8; i++) {
				int nx1 = x + dx1[i];
				int ny1 = y + dy1[i];

				if (!range(nx1, ny1)) continue;
				if (!hurdle(nx1, ny1, c2, r2)) continue;

				int nx2 = nx1 + dx2[i];
				int ny2 = ny1 + dy2[i];

				if (!range(nx2, ny2)) continue;
				if (!hurdle(nx2, ny2, c2, r2)) continue;

				int nx3 = nx2 + dx3[i];
				int ny3 = ny2 + dy3[i];

				if (!range(nx3, ny3)) continue;
				if (!visitCheck(nx3, ny3, visited)) continue;

				que.add(new int[]{ny3, nx3, cnt + 1});
				visited[ny3][nx3] = true;

			}


		}

		System.out.println(-1);
	}

	public static boolean range(int x, int y) {
		return x >= 0 && x < 9 && y >= 0 && y < 10;
	}

	public static boolean hurdle(int x, int y, int c2, int r2) {
		if (x == c2 && y == r2) {
			return false;
		}
		return true;
	}

	public static boolean visitCheck(int x, int y, boolean[][] visited) {
		if (visited[y][x]) return false;
		return true;
	}
}
