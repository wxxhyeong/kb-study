package 김민지.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class obj1167_mj { // 트리의 지름
    static List<Node>[] graph;
    static boolean[] visited;
    static int result = 0;
    static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        // graph 생성
        for (int i = 0; i< N + 1; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            while(true) {
                int n = Integer.parseInt(st.nextToken());
                if(n == -1)
                    break;
                int cost = Integer.parseInt(st.nextToken());
                graph[vertex].add(new Node(n,cost));
            }
        }

        //임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장한다.
        visited = new boolean[N + 1];
        dfs(1, 0);

        //node에서 부터 가장 먼 노트까지의 거리를 구한다.
        visited = new boolean[N + 1];
        dfs(node, 0);

        System.out.println(result);
    }

    public static void dfs(int x, int cost) {
        if(cost > result) {
            result = cost;
            node = x;
        }
        visited[x] = true;

        for(int i = 0; i < graph[x].size(); i++) {
            Node n = graph[x].get(i);
            if(visited[n.e] == false) {
                dfs(n.e, n.cost + cost);
                visited[n.e] = true;
            }
        }
    }

    static class Node {
        int e, cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}
