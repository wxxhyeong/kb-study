package 김민지.week10;

import java.util.*;

public class leet1514_mj {  //  Path with Maximum Probability
    public static void main(String[] args) {
        System.out.println(maxProbability(3, new int[][]{{0,1}, {1,2}, {0,2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));
        System.out.println(maxProbability(3, new int[][]{{0,1}}, new double[]{0.5}, 0, 2));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // costs 초기화
        double[] costs = new double[n];
        Arrays.fill(costs, 0);

        // graph 초기화
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i=0; i<edges.length; i++) {
            int s = edges[i][0];
            int e = edges[i][1];
            double c = succProb[i];
            graph.get(s).add(new Edge(e,c));
            graph.get(e).add(new Edge(s,c));
        }

        // 다익스트라
        Queue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start_node,1.0));
        costs[start_node] = 1.0;
        while (!q.isEmpty()) {
            Edge now = q.poll();

            if (now.c < costs[now.v]) continue;
//            if (now.v == end_node) return now.c;    // 좀 더 빠름. 근데 더 큰 경우가 뒤에 있으면,,,,??

            for (Edge next : graph.get(now.v)) {
                double newCost = next.c * now.c;
                if (newCost > costs[next.v]) {
                    costs[next.v] = newCost;
                    q.add(new Edge(next.v, newCost));
                }
            }
        }

        return costs[end_node];
    }

    static class Edge implements Comparable<Edge> {
        int v;
        double c;
        public Edge(int v, double c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(o.c, this.c);     // double 비교시 반드시 요렇게 !
        }
    }
}