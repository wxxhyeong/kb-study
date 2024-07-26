package 장성훈.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj11724_sh {
    public static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int n : adj.get(node)) {
            if (!visited[n]) {
                dfs(n, adj, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
