package 장성훈.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753_sh {
    static ArrayList<int[]>[] graph;
    static int V;
    static int E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[]{v, w});
        }

        dijkstra(start, 1);
    }

    public static void dijkstra(int start, int end) {
        int[] dist = new int[V+1];
        Arrays.fill(dist, 200000);

        PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2) -> o1[1] - o2[1] );
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int now = curr[0];
            int d = curr[1];

            for (int[] edge : graph[now]) {
                int next = edge[0];
                int nextW = edge[1];
                if (dist[next] > d + nextW) {
                    dist[next] = d + nextW;
                    pq.offer(new int[]{next, d + nextW});
                }
            }
        }
        dist[start] = 0;
        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == 200000 ? "INF" : dist[i]);
        }
    }
}
