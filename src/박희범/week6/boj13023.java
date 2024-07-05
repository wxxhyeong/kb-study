package 박희범.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj13023 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        System.out.println(checkRelation(N, graph) ? 1 : 0);
    }

    private static boolean checkRelation(int N, List<List<Integer>> graph) {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            if(backtracking(0, i, graph, visited))
                return true;
            visited[i] = false;
        }
        return false;
    }

    static boolean backtracking(int depth, int cur, List<List<Integer>> graph, boolean[] visited){
        if(depth == 4)
            return true;

        for(int next : graph.get(cur)){
            if(visited[next])
                continue;
            visited[next] = true;
            if(backtracking(depth + 1, next, graph, visited))
                return true;
            visited[next] = false;
        }
        return false;
    }
}
