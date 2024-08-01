package 장성훈.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tree {
    private int V;
    LinkedList<Edge>[] adjList;

    class Edge {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public Tree(int v) {
        this.V = v;
        adjList = new LinkedList[v + 1];
        for (int i = 0; i <= v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest, int w) {
        adjList[src].add(new Edge(dest, w));
        adjList[dest].add(new Edge(src, w));
    }

    public int[] bfs(int start) {
        boolean[] visited = new boolean[V + 1];
        int[] res = new int[V + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Edge edge : adjList[cur]) {
                if (!visited[edge.node]) {
                    visited[edge.node] = true;
                    res[edge.node] = res[cur] + edge.weight;
                    queue.add(edge.node);
                }
            }
        }

        return res;
    }

    public int findLongestPath() {
        // 가장 먼 노드를 찾기
        int[] distances = bfs(1);
        int maxDist = 0, maxNode = 0;

        for (int i = 1; i <= V; i++) {
            if (distances[i] > maxDist) {
                maxDist = distances[i];
                maxNode = i;
            }
        }

        // 노드간 최장 거리를 찾기
        distances = bfs(maxNode);
        maxDist = 0;

        for (int i = 1; i <= V; i++) {
            if (distances[i] > maxDist) {
                maxDist = distances[i];
            }
        }
        return maxDist;
    }
}

public class boj1167_sh {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree(n);

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            while (true) {
                int dest = Integer.parseInt(st.nextToken());
                if (dest == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                tree.addEdge(src, dest, w);
            }
        }
        System.out.println(tree.findLongestPath());
    }
}
