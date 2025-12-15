package jaebin.brute_force.baekjoon25542;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken());
		int l = Integer.parseInt(stk.nextToken());

		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}

		for (int i = 0; i < n; i++) {
			char[] base = words[i].toCharArray();

			if (isValid(base, words, n, l)) {
				System.out.println(new String(base));
				return;
			}

			for (int pos = 0; pos < l; pos++) {
				char orig = base[pos];
				for (char c = 'A'; c <= 'Z'; c++) {
					if (c == orig) continue;
					base[pos] = c;

					if (isValid(base, words, n, l)) {
						System.out.println(new String(base));
						return;
					}
				}
				base[pos] = orig;
			}
		}
		System.out.println("CALL FRIEND");

	}

	private static boolean isValid(char[] cand, String[] words, int n, int l) {
		for (int i = 0; i < n; i++) {
			int diff = 0;
			String w = words[i];
			for (int j = 0; j < l; j++) {
				if (w.charAt(j) != cand[j]) {
					diff++;
					if (diff > 1) return false;
				}
			}
		}
		return true;
	}

}
