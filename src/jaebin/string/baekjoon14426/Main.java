package jaebin.string.baekjoon14426;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static class Trie {

		static TrieNode root;

		Trie() {
			this.root = new TrieNode();
		}

		public static class TrieNode {
			Map<Character, TrieNode> childNode;
			boolean isEndOfWord;

			TrieNode() {
				this.childNode = new HashMap<>();
			}
		}

		public static void insert(String s) {
			TrieNode node = root;

			for (char c : s.toCharArray()) {
				if (!node.childNode.containsKey(c)) {
					node.childNode.put(c, new TrieNode());
				}

				node = node.childNode.get(c);
			}

			node.isEndOfWord = true;
		}

		public static boolean check(String prefix){
			TrieNode node = root;

			for(char c : prefix.toCharArray()){
				if(!node.childNode.containsKey(c)){
					return false;
				}

				node = node.childNode.get(c);
			}

			return true;
		}


	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		Trie trie = new Trie();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			trie.insert(s);
		}

		int count = 0;

		for (int i = 0; i < m; i++) {
			String s = br.readLine();

			if(Trie.check(s)){
				count++;
			}
		}

		System.out.println(count);
	}
}
