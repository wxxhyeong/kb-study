package 장성훈.week6;

import java.util.*;

public class boj1260_sh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), v = sc.nextInt();
        boolean[] visited;
        int[][] graph = new int[n+1][n+1];
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[n+1];
        dfs(graph,visited,v);

        System.out.println();

        visited = new boolean[n+1];
        bfs(graph,visited,v);
    }

    public static void dfs(int[][] graph, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v+" ");
        for (int i = 1; i < graph.length; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(graph,visited,i);
            }
        }
    }

    public static void bfs(int[][] graph, boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur+" ");
            for (int i = 0; i < graph[cur].length; i++) {
                if (graph[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}


//Scanner S = new Scanner(System.in);
//        int N = S.nextInt(), M = S.nextInt(), V = S.nextInt();
//int A[][] = new int[N+1][N+1];
//int C[] = new int[N+1];
//int i = 0;