package 김민지.week8;

import java.io.*;
import java.util.*;

public class boj1707_mj {   // 이분 그래프
    // BFS, DFS
    // 서로 인접한 정점이 같은 색이면 이분 그래프가 아니다.
    // 주의 : 연결 그래프와 비연결 그래프 모두 고려

    static List<Integer>[] graph;
    static int[] colors;    // 0 : 미방문, 1 : red, -1 : blue
    static boolean isBipartite = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());   // 정점
            int E = Integer.parseInt(st.nextToken());   // 간선

            graph = new ArrayList[V];
            colors = new int[V];
            isBipartite = true;

            for (int i = 0; i < V; i++) {
                graph[i] = new ArrayList<>();
                colors[i] = 0;
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a-1].add(b-1);
                graph[b-1].add(a-1);
            }

            // 모든 정점을 돌면서 확인
            for (int i = 0; i < V; i++) {
                if (!isBipartite)
                    break;

                if (colors[i] == 0) {    // 미방문
                    DFS(i, 1);
//                    BFS(i, 1);
                }
            }

            if (isBipartite) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void DFS(int node, int color) {
        colors[node] = color;

        for (Integer next : graph[node]) {
            // 인접한 정점의 색이 같으면 이분 그래프가 아님
            if (colors[next] == color) {
                isBipartite = false;
                return;
            }

            if (colors[next] == 0) {    // 미방문
                DFS(next, -color);
            }
        }
    }

    public static void BFS(int node, int color) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(node);
        colors[node] = color;

        while(!que.isEmpty() && isBipartite) {
            int v = que.poll();

            for (Integer next : graph[v]) {
                // 인접한 정점의 색이 같으면 이분 그래프가 아님
                if (colors[next] == colors[v]) {
                    isBipartite = false;
                    return;
                }

                if (colors[next] == 0) {    // 미방문
                    que.offer(next);
                    colors[next] = -colors[v];
                }
            }
        }
    }
}
