package 장성훈.week10;

import java.util.*;

public class leet_network_delay_time_sh {
    static ArrayList<int[]>[] graph;

    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            graph[time[0]].add(new int[]{time[1], time[2]});
        }

        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] visited = new int[n+1];
        int answer = 0;
        int cnt = 0;

        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int now = poll[0];
            int dist = poll[1];
            if (visited[now] != 0) continue;

            visited[now] = 1;
            answer = Math.max(answer, dist);
            cnt++;


            for (int[] time : graph[now]) {
                pq.offer(new int[]{time[0], time[1] + dist});
            }
        }

        return (cnt==n) ? answer : -1;
    }
}