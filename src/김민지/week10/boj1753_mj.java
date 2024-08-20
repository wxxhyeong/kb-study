package 김민지.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1753_mj {   // 최단경로 - 방향그래프/가중치o

    static class Edge implements Comparable<Edge> {
        int v, c;
        public Edge(int v, int c) {
            this.v = v; // 정점
            this.c = c; // 가중치
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    static int[] costs;
    static Map<Integer, List<Edge>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());   // 정점 개수 - 1 ~ V 까지
        int E = Integer.parseInt(st.nextToken());   // 간선 개수

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()) - 1;   // 시작 정점

        // graph 초기화
        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Edge(e,c));
        }

        // costs 초기화
        costs = new int[V];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(costs, INF);

        // 다익스트라
        Queue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(K, 0));
        costs[K] = 0;

        while (!q.isEmpty()) {
            Edge now = q.poll();

            if (now.c > costs[now.v]) continue;

            for (Edge next : graph.get(now.v)) {
                int newCost = costs[now.v] + next.c;
                if (newCost < costs[next.v]) {
                    q.add(new Edge(next.v, newCost));
                    costs[next.v] = newCost;
                }
            }
        }

        for (int c : costs) {
            if (c == INF) System.out.println("INF");
            else System.out.println(c);
        }
    }
}
