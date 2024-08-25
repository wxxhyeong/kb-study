package 장성훈.week10;

import java.util.*;
public class leet_path_with_maximum_probability_sh {

    ArrayList<double[]>[] graph;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        graph = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph[edge[0]].add(new double[]{edge[1], succProb[i]});
            graph[edge[1]].add(new double[]{edge[0], succProb[i]});
        }

        double[] costs = new double[n+1];
        Arrays.fill(costs, 2);

        PriorityQueue<double[]> pq = new PriorityQueue<>(
                (double[] o1, double[] o2) -> {
                    if (o1[0] == o2[0]) {
                        return Double.compare(o1[1], o2[1]);
                    }
                    return Double.compare(o1[0], o2[0]);
                }
        );

        costs[start_node] = 1;
        pq.offer(new double[]{start_node, 1});

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int now = (int) curr[0];
            double nowProb = curr[1];

            if (costs[now] > 1) continue;

            for (double[] edge : graph[now]) {
                int next = (int) edge[0];
                double nextProb = edge[1];

                if (costs[next] > 1) {
                    pq.offer(new double[]{next, nowProb*nextProb});
                } else {
                    if (costs[next] < nowProb*nextProb) {
                        costs[next] = nowProb*nextProb;
                        pq.offer(new double[]{next, nowProb*nextProb});
                    }
                }
            }
        }

        return costs[end_node];
    }


}
