package 장성훈.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1707_sh {
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            Boolean[] visited = new Boolean[V+1];
            Arrays.fill(visited, false);
            Boolean[] color = new Boolean[V+1];
            Arrays.fill(color, false);
            isBipartite = true;

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map.putIfAbsent(a, new ArrayList<>());
                map.putIfAbsent(b, new ArrayList<>());
                map.get(a).add(b);
                map.get(b).add(a);
            }

            for (int now = 1; now <= V; now++) {
                if (!visited[now]) {
                    bfs(now, visited, color, map);
                    if (!isBipartite) {
                        break;
                    }
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    public static void bfs(int start, Boolean[] visited, Boolean[] color, HashMap<Integer, ArrayList<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        color[start] = true;

        while (!queue.isEmpty() && isBipartite) {
            int now = queue.poll();

            if (map.get(now) == null) { continue; }
            for (int next : map.get(now)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    color[next] = !color[now];
                } else if (color[next] == color[now]) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}
