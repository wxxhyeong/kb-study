package 김민지.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class obj1260_mj {  // DFS와 BFS
    static ArrayList<Integer>[] graph;
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited_dfs = new boolean[N + 1];
        visited_bfs = new boolean[N + 1];
        sb = new StringBuilder();

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 오름차순 정렬
        for (int i = 0; i < N + 1; i++) {
            ArrayList<Integer> list = graph[i];
            Collections.sort(list);
            graph[i] = list;
        }

        DFS(start);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        BFS(start);
        System.out.println(sb.toString());
    }

    public static void DFS(int index) {
        if (visited_dfs[index]) {
            return;
        }
        visited_dfs[index] = true;
        sb.append(index).append(" ");
        for (Integer v : graph[index]) {
            if (!visited_dfs[v]) {
                DFS(v);
            }
        }
    }

    public static void BFS(int index) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(index);
        visited_bfs[index] = true;

        while (!q.isEmpty()) {
            Integer v = q.poll();
            sb.append(v).append(" ");
            for (Integer w : graph[v]) {
                if (!visited_bfs[w]) {
                    q.add(w);
                    visited_bfs[w] = true;
                }
            }
        }
    }
}