package yunhwan.random;

import java.io.*;
import java.util.*;


public class N1916 {

    static class Edge{
        int to;
        int w;
        Edge(int to, int w){this.to = to; this.w = w;}
    }
    static class Node{
        int v;
        int dist;
        Node(int v, int dist){this.v = v; this.dist = dist;}
    }

    static final int INF = 1_00_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            N개의 도시
            M개의 버스
            A -> B 버스 비용 최소화
         */
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Edge>[] edge = new ArrayList[N + 1];
        for(int i=1; i<=N; i++){ edge[i] = new ArrayList<>(); }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edge[s].add(new Edge(t, w));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startV = Integer.parseInt(st.nextToken());
        int endV = Integer.parseInt(st.nextToken());

        dijkstra(startV, endV, edge, dist);

        System.out.println(dist[endV]);

    }

    public static void dijkstra(int start, int end, List<Edge>[] edge, int[] dist){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[edge.length];

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int v = cur.v;

            if(v == end) break;

            if(visited[v]) continue;
            visited[v] = true;

            for(Edge e : edge[v]){
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
