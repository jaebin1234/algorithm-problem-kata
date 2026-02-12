package queue.programmers42587;

import java.util.*;

class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		int n = priorities.length;

		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> indexQue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			que.add(priorities[i]);
			indexQue.add(i);
		}

		int[] rankArr = new int[n];
		int rank = 1;

		loop:
		while (!que.isEmpty()) {
			int curPoint = que.poll();
			int curIndex = indexQue.poll();

			boolean hasHigher = false;
			for (int comparePoint : que) {
				if (comparePoint > curPoint) {
					hasHigher = true;
					break;
				}
			}

			if (hasHigher) {
				que.add(curPoint);
				indexQue.add(curIndex);
				continue;
			} else {
				rankArr[curIndex] = rank;
				rank++;
			}

		}

		answer = rankArr[location];

		return answer;
	}
}