package 김민지.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj13023 {
    // ABCDE
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean foundABCDE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        graph = new ArrayList[N];
        visited = new boolean[N];
        foundABCDE = false;

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 방향이 없으므로 모두에게 채워주기
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < N; i++) {
            if (!foundABCDE) {
                dfs(i, 0);
            }
        }
        System.out.println(0);
    }

    public static void dfs(int v, int depth) {
        if (depth == 4 && !foundABCDE) {
            System.out.println(1);
            System.exit(0);
        }
        visited[v] = true;
        for (int a : graph[v]) {
            if (!visited[a]) {
                dfs(a, depth + 1);
            }
        }
        visited[v] = false; // 백트레킹
    }
}