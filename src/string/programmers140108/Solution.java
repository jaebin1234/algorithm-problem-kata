package string.programmers140108;

class Solution {
	public int solution(String s) {
		int answer = 0;
		int n = s.length();

		int curCnt = 0;
		int compareCnt = 0;

		char cur = 'a';
		for (int i = 0; i < n; i++) {
			if (curCnt == 0 && compareCnt == 0) {
				cur = s.charAt(i);
				curCnt++;
				continue;
			}

			char compare = s.charAt(i);

			if (cur == compare) {
				curCnt++;
			} else {
				compareCnt++;
			}

			if (curCnt == compareCnt) {
				curCnt = 0;
				compareCnt = 0;
				answer++;
			}
		}

		if (curCnt != 0 || compareCnt != 0) {
			curCnt = 0;
			compareCnt = 0;
			answer++;
		}

		return answer;
	}
}