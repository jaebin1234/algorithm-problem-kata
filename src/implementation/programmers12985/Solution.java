package implementation.programmers12985;

class Solution {
	public int solution(int n, int a, int b) {
		int answer = 0;

		int aCur = a;
		int bCur = b;

		while (aCur != bCur) {
			aCur = (aCur + 1) / 2;
			bCur = (bCur + 1) / 2;
			answer++;
		}

		return answer;
	}
}