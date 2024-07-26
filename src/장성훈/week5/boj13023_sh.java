package 장성훈.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj13023_sh {
    public static boolean isFriend = false;

    public static void dfs(int node, List<List<Integer>> adj, boolean[] visited, int cnt) {
        if (isFriend || cnt == 5) {
            isFriend = true;
            return;
        }

        for (int n : adj.get(node)) {
            if (!visited[n]) {
                visited[node] = true;
                dfs(n, adj, visited, cnt+1);
                visited[node] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, adj, visited, 1);
                visited[i] = false;
            }
        }
        System.out.println(isFriend ? 1 : 0);
    }
}
