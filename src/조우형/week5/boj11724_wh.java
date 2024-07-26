package 조우형.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11724_wh {

    static boolean visited[];
    static ArrayList<Integer>[] graph;
    static int n, m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        int result = 0;

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]){
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int n) {

        if (visited[n]){
            return;
        }

        visited[n] = true;

        for (int i = 0; i < graph[n].size(); i++) {
            dfs(graph[n].get(i));
        }
    }
}
