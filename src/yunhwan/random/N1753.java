package yunhwan.random;

import java.io.*;
import java.util.*;

public class N1753 {
    static class Edge {
        int to;
        int w;
        Edge(int to, int w){ this.to = to; this.w = w; }
    }

    static class Node {
        int v;
        int dist;
        Node(int v, int dist){ this.v = v; this.dist = dist; }
    }

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 <= 20,000
        int E = Integer.parseInt(st.nextToken()); // 간선 <= 300,000
        int K = Integer.parseInt(br.readLine()); // 시작 정점

        // 인접 리스트
        List<Edge>[] g = new ArrayList[V + 1];
        for(int i=1; i<=V; i++){ g[i] = new ArrayList<>(); }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[u].add(new Edge(v, w));
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dijkstra(K, g, dist);

        for(int i=1; i<=V; i++){
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }

    public static void dijkstra(int start, List<Edge>[] g, int[] dist){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[g.length];

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int v = cur.v;

            // 이미 더 좋은 거리로 확정된 적 있으면 스킵
            if(visited[v]) continue;
            visited[v] = true;

            for(Edge e : g[v]){
                if(visited[e.to]) continue;
                int nd = dist[v] + e.w;
                if(nd < dist[e.to]){
                    dist[e.to] = nd;
                    pq.offer(new Node(e.to, nd));
                }
            }
        }

    }
}
