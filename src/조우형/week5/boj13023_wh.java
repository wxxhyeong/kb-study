package 조우형.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class boj13023_wh {

    static ArrayList<Integer>[] graph;
    final static int LOOP = 5;
    static int n,m;
    static boolean[] visited;
    static boolean state;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        visited = new boolean[n];

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        state = false;

        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            if (state) {
                break;
            }
        }

        System.out.println(state ? 1 : 0);
    }

    static public void dfs(int start, int cnt) {
        //System.out.print(start+"\t");
        //System.out.println("count = " + count);
        if (cnt == LOOP) {
            state = true;
            return;
        }

        visited[start] = true;

        for (Integer i : graph[start]) {

            if (!visited[i]) {
                dfs(i, cnt+1);
            }
        }

        visited[start] = false;

    }
}
