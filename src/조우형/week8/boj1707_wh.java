package 조우형.week8;

import java.util.*;
import java.io.*;

class boj1707_wh {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            StringTokenizer stk = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(stk.nextToken());
            int E = Integer.parseInt(stk.nextToken());

            ArrayList<Integer>[] al = new ArrayList[V+1];
            for (int j = 1; j < V + 1; j++) {
                al[j] = new ArrayList<>();
            }

            for (int e = 0; e < E; e++) {
                stk = new StringTokenizer(br.readLine());

                int n1 = Integer.parseInt(stk.nextToken());
                int n2 = Integer.parseInt(stk.nextToken());

                al[n1].add(n2);
                al[n2].add(n1);
            } // 노드와 간선 연걸

            Deque<Integer> deque = new ArrayDeque<>();
            int[] visited = new int[V+1];
            boolean state = true;

            for (int v = 1; v <= V; v++) {
                if (visited[v] == 0) {
                    deque.add(v);
                    visited[v] = 1;

                    while (!deque.isEmpty()) {
                        int cur = deque.pollFirst();

                        for (int next : al[cur]) {
                            if (visited[next] == 0) {
                                visited[next] = -visited[cur];
                                deque.add(next);
                            }
                            else if (visited[next] == visited[cur]) {
                                state = false;

                            }
                        }
                    }
                }
            }

            if (state) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }

        } // test for문

    } // main 메서드
}
