package bfs.baekjoon3055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static class Pos {
		int x;
		int y;
		int time;

		Pos(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null && getClass() != o.getClass()) return false;

			Pos pos = (Pos) o;

			return x == pos.x && y == pos.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());

		String[][] arr = new String[r][c];

//		Set<Pos> set = new HashSet<>();
		Map<Pos, Integer> map = new HashMap<>();

		int startX = 0;
		int startY = 0;

		int endX = 0;
		int endY = 0;

		//우하좌상
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};

		Queue<Pos> waterQue = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = s.substring(j, j + 1);

				if(arr[i][j].equals("S")){
					startX = j;
					startY = i;
				}

				if(arr[i][j].equals("D")){
					endX = j;
					endY = i;
				}

				if(arr[i][j].equals("*")){
					map.put(new Pos(j, i, 0), 0);
				}
			}
		}

		for(Pos p : map.keySet()){
			waterQue.add(p);
		}

		while (!waterQue.isEmpty()){
			Pos p = waterQue.poll();

			for(int i = 0; i<4; i++){
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				if(ny >= r || ny < 0 || nx >= c || nx < 0){
					continue;
				}

				if(endX == nx && endY == ny){
					continue;
				}

				if(arr[ny][nx].equals("X")){
					continue;
				}

				Pos nextPos = new Pos(nx, ny, p.time + 1);

				if(map.containsKey(nextPos)){
					continue;
				}

				map.put(nextPos, p.time + 1);
				waterQue.add(nextPos);
			}
		}

//		for(Map.Entry<Pos, Integer> entry : map.entrySet()){
//			System.out.println(entry.getKey().x + " " + entry.getKey().y + " " + entry.getValue());
//		}


		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[r][c];

		que.add(new Pos(startX, startY, 0));
		visited[startY][startX] = true;

		boolean isSuccess = false;
		int result = 0;

		while (!que.isEmpty()){
			Pos cur = que.poll();
			int cx = cur.x;
			int cy = cur.y;
			int ct = cur.time;

			if(cx == endX && cy == endY){
				isSuccess = true;
				result = ct;
				break;
			}

			for(int i = 0; i<4; i++){
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				int nt = ct + 1;

				if(ny >= r || ny < 0 || nx >= c || nx < 0){
					continue;
				}

				if(visited[ny][nx]){
					continue;
				}

				if(arr[ny][nx].equals("X")){
					continue;
				}

				Pos next = new Pos(nx, ny, ct + 1);

				if(map.containsKey(next) && nt >= map.get(next)){
					continue;
				}

				que.add(next);
				visited[ny][nx] = true;
			}

		}

		if(!isSuccess){
			System.out.println("KAKTUS");
			return;
		}

		System.out.println(result);

	}
}
