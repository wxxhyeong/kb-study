package 조우형.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1260_wh {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb1 = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int v = Integer.parseInt(stk.nextToken());

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int fir = Integer.parseInt(stk.nextToken());
            int sec = Integer.parseInt(stk.nextToken());

            graph[fir].add(sec);
            graph[sec].add(fir);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        //System.out.println(Arrays.toString(graph));

        dfs(v);
        sb1.append("\n");
        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(sb1.toString());
    }


    static void dfs(int v) {

        visited[v] = true;
        sb1.append(v+"\t");

        for (int i = 0; i < graph[v].size(); i++) {
            int next = graph[v].get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int v) {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(v);
        visited[v] = true;
        while (!deque.isEmpty()) {
            //System.out.println("deque.toString() = " + deque.toString());
            int now = deque.pollFirst();


            sb1.append(now + " ");

            for (Integer i : graph[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    deque.addLast(i);
                }
            }
        }
    }
}
