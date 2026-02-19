package queue.programmers131704;

import java.util.*;
import java.util.*;

class Solution {
	public int solution(int[] order) {
		int answer = 0;

		Queue<Integer> main = new LinkedList<>();
		Stack<Integer> sub = new Stack<>();

		int n = order.length;

		// 메인 컨베이어에 1..n 적재
		for (int i = 1; i <= n; i++) {
			main.add(i);
		}

		int idx = 0; // order에서 현재 목표 인덱스

		while (idx < n) {
			int target = order[idx];

			// 1) 보조 컨베이어 top이 target이면 바로 처리
			if (!sub.isEmpty() && sub.peek() == target) {
				sub.pop();
				answer++;
				idx++;
				continue;
			}

			// 2) 메인 컨베이어에서 꺼낼 상자가 없으면 더 이상 진행 불가
			if (main.isEmpty()) {
				break;
			}

			// 3) 메인에서 하나 꺼내서 target이면 처리, 아니면 보조로 보냄
			int cur = main.poll();
			if (cur == target) {
				answer++;
				idx++;
			} else {
				sub.push(cur);
			}
		}

		return answer;
	}
}