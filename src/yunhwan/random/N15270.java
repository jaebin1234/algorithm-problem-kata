package yunhwan.random;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N15270 {
    static int N, M;
    static List<Integer>[] friends;
    static boolean[] visit;
    static int maxPair = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friends = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            friends[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        /*
            친한 친구 리스트를 통해 쌍을 찾아야 함
            1. 사람(idx), 쌍 개수(pairCount)
         */

        dfs(1, 0);

        int res = maxPair * 2 + (maxPair * 2 < N ? 1 : 0);
        System.out.println(res);
    }

    public static void dfs(int idx, int pairCount){
        // 탐색 끝
        if(idx > N){
            maxPair = Math.max(maxPair, pairCount);
            return;
        }

        // 이미 쌍을 이룸
        if(visit[idx]){
            dfs(idx + 1, pairCount);
            return;
        }

        // 혼자 로봇춤
        dfs(idx + 1, pairCount);

        // 친구와 쌍을 이룸
        for(int f : friends[idx]){
            visit[f] = true;
            visit[idx] = true;
            dfs(idx + 1, pairCount + 1);
            visit[f] = false;
            visit[idx] = false;
        }
    }
}
