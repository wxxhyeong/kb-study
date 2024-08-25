package 장성훈.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1916_sh {
    static ArrayList<int[]>[] graph;
    static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[]{v, w});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2) -> o1[1] - o2[1] );
        pq.offer(new int[]{start, 0});
        int[] cost = new int[N+1];
        Arrays.fill(cost, MAX);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int now = curr[0];
            int distance = curr[1];

            if (cost[now] < distance) continue;

            for (int[] edge : graph[now]) {
                int next = edge[0];
                int weight = edge[1];

                if (cost[next] > distance + weight) {
                    cost[next] = distance + weight;
                    pq.offer(new int[]{next, distance + weight});
                }
            }
        }

        System.out.println(cost[end]);
    }
}
