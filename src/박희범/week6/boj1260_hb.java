package 박희범.week6;

import java.io.*;
import java.util.*;

public class boj1260_hb {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        dfs(V, graph, new boolean[graph.size()]);
        bw.write("\n");
        bfs(V, graph);
        bw.flush();
        bw.close();
    }

    static void dfs(int cur, List<List<Integer>> graph, boolean[] visited) throws IOException {
        bw.write(cur + " ");
        visited[cur] = true;
        for (int next : graph.get(cur)) {
            if (visited[next])
                continue;
            dfs(next, graph, visited);
        }
    }

    static void bfs(int V, List<List<Integer>> graph) throws IOException {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V] = true;
        bw.write(V+" ");
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if(visited[next])
                    continue;
                visited[next] = true;
                bw.write(next+" ");
                q.add(next);
            }
        }
    }
}
