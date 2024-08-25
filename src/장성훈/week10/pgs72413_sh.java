package 장성훈.week10;

import java.util.*;

public class pgs72413_sh {

    ArrayList<int[]>[] graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            graph[fare[0]].add(new int[]{fare[1], fare[2]});
            graph[fare[1]].add(new int[]{fare[0], fare[2]});
        }

        int[] sCost = dijkstra(s, n);
        int[] aCost = dijkstra(a, n);
        int[] bCost = dijkstra(b, n);

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (sCost[i] != Integer.MAX_VALUE &&
                    aCost[i] != Integer.MAX_VALUE &&
                    bCost[i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, sCost[i] + aCost[i] + bCost[i]);
            }
        }

        return answer;
    }

    public int[] dijkstra(int start, int n) {
        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});
        costs[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int nowIdx = cur[0];
            int nowCost = cur[1];

            if (costs[nowIdx] < nowCost) continue;

            for (int[] fare : graph[nowIdx]) {
                int nextIdx = fare[0];
                int estimateCost = nowCost + fare[1];

                if (estimateCost < costs[nextIdx]) {
                    costs[nextIdx] = estimateCost;
                    pq.offer(new int[]{nextIdx, estimateCost});
                }
            }
        }
        return costs;
    }
}
